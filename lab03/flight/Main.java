/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-03-09
 */

package lab03.flight;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    private final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        FlightManager fm = new FlightManager();
        showMenuOptions();
        while (true) {
            System.out.println("\nEscolha uma opção: (H para ajuda)");
            char option = sc.next().trim().charAt(0);
            switch (option) {
                case 'I':
                    String filename = sc.nextLine().trim();
                    fm.addFlightByFilename(filename);
                    break;
                case 'M':
                    String flightCode = sc.nextLine().trim();
                    fm.showFlight(flightCode);
                    break;
                case 'F':
                    String fConfig = sc.nextLine().trim();
                    fm.addFlightByString(fConfig);
                    break;
                case 'R':
                    String rConfig = sc.nextLine().trim();
                    String ret = fm.reserveTicketByString(rConfig);
                    if (ret != null) {
                        System.out.println(ret);
                    }
                    break;
                case 'C':
                    String cConfig = sc.nextLine().trim();
                    fm.cancelReservationByString(cConfig);
                    break;
                case 'Q':
                    System.out.println("Programa terminou!");
                    System.exit(1);
                default:
                    showMenuOptions();
                    break;
            }
        }
    }

    private static void showMenuOptions() {
        System.out.println("Opções do menu:");
        System.out.println("[H] - Ajuda");
        System.out.println("[I] <filename> - adiciona um voo definido num ficheiro de texto");
        System.out.println("[M] <flightCode> - exibe o mapa das reservas de um voo");
        System.out.println("[F] <flightCode> [seats_executive] <seats_touristic> - acrescenta um novo voo");
        System.out.println("[R] <flightCode> <T|E> <number_seats> - acrescenta uma nova reserva a um voo");
        System.out.println("[C] <flightCode>:<reservationID> - cancela uma reserva");
    }
}
