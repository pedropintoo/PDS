/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-03-09
 */

package lab03.flight;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FlightManager fm = new FlightManager();
        fm.addFlightByFilename("lab03/flight/data/flight1.txt");
        Flight f = fm.getFlight("TP1920");
        f.showMap();
        System.out.println();
        f.cancelReservation(1);
        f.reserveTicket(TicketClass.Touristic, 4);
        f.showMap();
    }
}
