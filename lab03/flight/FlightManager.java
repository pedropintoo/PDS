/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-03-04
 */

package lab03.flight;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class FlightManager {

    private HashMap<String, Flight> MapOfFlights;

    public FlightManager() {
        MapOfFlights = new HashMap<>();
    }
    
    public void addFlightByFilename(String filename) throws FileNotFoundException{
        Scanner sc = new Scanner(new FileReader(filename));

        String header = sc.nextLine();
        
        if (!isHeaderValid(header)) {
            System.err.println("Invalid Header!");
            System.exit(1);
        }

        Flight flight = addFlightByString(header.substring(1));
        
        //System.out.println("[FLIGHT] - "+flight);

        // Make the reservations
        while (sc.hasNextLine()) {
            String rConfig = sc.nextLine();
            
            reserveTicketByString(flight, rConfig);
        }

        sc.close();
    } 

    public Flight addFlightByString(String fConfig) {
        // Add Flight to the Map

        if (!isFlightConfigValid(fConfig)) {
            System.err.println("Invalid Flight Configuration!");
            System.exit(1);
        }

        String[] info = fConfig.split(" ");
        String flightCode = info[0];
        
        String[] infoTouristic = info[info.length-1].split("x");
        int colsTouristic = Integer.parseInt(infoTouristic[0]);
        int rowsTouristic = Integer.parseInt(infoTouristic[1]);
        int seatsTouristic = colsTouristic*rowsTouristic;

        Flight flight = null;
        output("Código de voo "+flightCode+". ");
        output("Lugares disponíveis: ");

        if (info.length == 2) {
            // Only Touristic seats
            flight = new Flight(flightCode, rowsTouristic, colsTouristic);
            output(seatsTouristic + " lugares em classe Turística.\n");
            output("Classe executiva não disponível neste voo.\n");
        } else {
            // Touristic seats & Exclusive seats
            String[] infoExclusive = info[1].split("x");
            int colsExclusive = Integer.parseInt(infoExclusive[0]);
            int rowsExclusive = Integer.parseInt(infoExclusive[1]);
            int seatsExclusive = colsExclusive*rowsExclusive;
            flight = new Flight(flightCode, rowsTouristic, colsTouristic, rowsExclusive, colsExclusive);
            
            output(seatsExclusive + " lugares em classe Executíva; ");
            output(seatsTouristic + " lugares em classe Turística.\n");
        } 
        

        MapOfFlights.put(flightCode, flight);
        return flight;
    }
    
    public void reserveTicketByString(Flight flight, String rConfig) {
        if (!isReservationValid(rConfig)) {
            System.err.println("Invalid Reservation!");
            System.exit(1);
        }
        
        String[] info = rConfig.split(" "); // <T|E> <reservations>
        char classSym = info[0].charAt(0);

        TicketClass ticketC = TicketClass.getTicketClass(classSym);
        int reservations = Integer.parseInt(info[1]);

        if(!flight.reserveTicket(ticketC, reservations)) {
            output("Não foi possível obter lugares para a reserva: "+rConfig+"\n");
        }
    }

    public void cancelReservationByString(String cConfig) {
        if (!isCancellingCodeValid(cConfig)) {
            System.err.println("Invalid Cancelling code!");
            System.exit(1);
        }
        
        String[] info = cConfig.split(" ");

        String flightCode = info[0];
        Flight flight = MapOfFlights.get(flightCode);

        int reservationID = Integer.parseInt(info[1]);
        
        if(!flight.cancelReservation(reservationID)){
            output("Não foi possível cancelar a reserva: "+cConfig+"\n");
        }
    }

    // Private Methods

    private void output(String str) {
        // only for clean code
        System.out.print(str);
    }

    private boolean isHeaderValid(String header) {

        if (header.length() < 2) return false;

        if (header.charAt(0) != '>') return false;

        return true;
    }

    private boolean isFlightConfigValid(String fConfig) {
        // <flightCode> [<queues>x<places>] <queues>x<places>

        String[] info = fConfig.split(" ");
        
        if (info.length == 1) return false;
        
        String flightCode = info[0];
        if(!Utils.isAlphaNumeric(flightCode)) return false;
        
        // check configurations
        for (int i = 1; i < info.length; i++) {
            if(!Utils.isIntegerXInteger(info[i])) return false;
        }
        
        return true;
    }

    private boolean isReservationValid(String reservation) {
        return reservation.matches("[T|E] [1-9][0-9]*");
    }

    private boolean isCancellingCodeValid(String cConfig) {
        // flightCode:reservationID

        String[] info = cConfig.split(":");
        if (info.length != 2) return false;

        String flightCode = info[0];
        Flight flight = null;
        flight = MapOfFlights.get(flightCode);

        if (flight == null) return false;
        
        String reservationID = info[1];

        if (!reservationID.matches("[1-9][0-9]*")) return false;

        return true;
    }

    // Getters & Setters
    public Flight getFlight(String flightCode) {
        return MapOfFlights.get(flightCode);
    }
}
