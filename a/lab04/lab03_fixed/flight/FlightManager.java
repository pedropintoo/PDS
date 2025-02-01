/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-03-04
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class FlightManager implements FlightManagerInterface{

    private HashMap<String, Flight> MapOfFlights;

    public FlightManager() {
        MapOfFlights = new HashMap<>();
    }
    
    public void addFlightByFilename(String filename) throws FileNotFoundException{
        Scanner sc;
        try {
            sc = new Scanner(new FileReader(filename));
        } catch (FileNotFoundException e) {
            output("Ficheiro não encontrado!\n");
            return;
        }

        String header = sc.nextLine();
        
        if (!isHeaderValid(header)) {
            output("Cabeçalho inválido!\n");
            sc.close();
            return;
        }

        Flight flight = addFlightByString(header.substring(1));
        
        if (flight == null) {
            sc.close();
            return;
        }

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
            System.err.println("Configuração de Voo inválida!");
            return null;
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
            // Touristic seats & Executive seats
            String[] infoExecutive = info[1].split("x");
            int colsExecutive = Integer.parseInt(infoExecutive[0]);
            int rowsExecutive = Integer.parseInt(infoExecutive[1]);
            int seatsExecutive = colsExecutive*rowsExecutive;
            flight = new Flight(flightCode, rowsTouristic, colsTouristic, rowsExecutive, colsExecutive);
            
            output(seatsExecutive + " lugares em classe Executíva; ");
            output(seatsTouristic + " lugares em classe Turística.\n");
        } 
        

        MapOfFlights.put(flightCode, flight);
        return flight;
    }
    
    public String reserveTicketByString(String rConfig) {
        String[] info = rConfig.split(" "); // flightCode <T|E> <reservations>

        String flightCode = info[0];
        Flight flight = getFlightByFlightCode(flightCode);

        if (flight == null) {
            System.err.println("Código de Voo inválido!");
            return null;
        }

        // Separate the flightCode from the reservation config
        rConfig = rConfig.substring(flightCode.length()+1);

        return reserveTicketByString(flight, rConfig);
    }

    public void cancelReservationByString(String cConfig) {
        if (!isCancellingCodeValid(cConfig)) {
            System.err.println("Código de cancelamento inválido!");
            return;
        }
        
        String[] info = cConfig.split(":"); // <flightCode>:<reservationID>

        String flightCode = info[0];
        Flight flight = MapOfFlights.get(flightCode);

        int reservationID = Integer.parseInt(info[1]);
        
        if(!flight.cancelReservation(reservationID)){
            output("Não foi possível cancelar a reserva: "+cConfig+"\n");
            return;
        }
    }

    public void showFlight(String flightCode) {
        Flight flight = getFlightByFlightCode(flightCode);
        
        if (flight == null) {
            System.err.println("Código de Voo inválido!");
            return;
        }

        flight.showMap();
    }

    // Private Methods

    private String reserveTicketByString(Flight flight, String rConfig) {
        if (!isReservationValid(rConfig)) {
            System.err.println("Reserva inválida!");
            return null;
        }
        
        String[] info = rConfig.split(" "); // <T|E> <reservations>
        char classSym = info[0].charAt(0);

        TicketClass ticketC = TicketClass.getTicketClass(classSym);
        int reservations = Integer.parseInt(info[1]);

        if(!flight.reserveTicket(ticketC, reservations)) {
            output("Não foi possível obter lugares para a reserva: "+rConfig+"\n");
            return null;
        } else {
            return flight.getLastReserve();
        }
    }

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
    private Flight getFlightByFlightCode(String flightCode) {
        return MapOfFlights.get(flightCode);
    }
}
