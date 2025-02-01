/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-03-09
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        FlightManager fm = new FlightManager();
        if (args.length > 0) {
            sc = new Scanner(new FileReader(args[0]));
        }
        showMenuOptions();
        System.out.println("\nEscolha uma opção: (H para ajuda)");
        while (sc.hasNextLine()) {
            char option = sc.next().trim().charAt(0);
            String config = sc.nextLine().trim();
            String ret;
            switch (option) {
                case 'I':
                    fm.addFlightByFilename(config);
                    break;
                case 'M':
                    fm.showFlight(config);
                    break;
                case 'F':
                    fm.addFlightByString(config);
                    break;
                case 'R':
                    ret = fm.reserveTicketByString(config);
                    if (ret != null) {
                        System.out.println(ret);
                    }
                    break;
                case 'C':
                    fm.cancelReservationByString(config);
                    break;
                case 'Q':
                    System.out.println("Programa terminou!");
                    System.exit(0);
                default:
                    showMenuOptions();
                    break;
            }
            System.out.println("\nEscolha uma opção: (H para ajuda)");
        }
        sc.close();
    }

    private static void showMenuOptions() {
        System.out.println("Opções do menu:");
        System.out.println("[H] - Ajuda");
        System.out.println("[I] <filename> - adiciona um voo definido num ficheiro de texto");
        System.out.println("[M] <flightCode> - exibe o mapa das reservas de um voo");
        System.out.println("[F] <flightCode> [seats_executive] <seats_touristic> - acrescenta um novo voo");
        System.out.println("[R] <flightCode> <T|E> <number_seats> - acrescenta uma nova reserva a um voo");
        System.out.println("[C] <flightCode>:<reservationID> - cancela uma reserva");
        System.out.println("[Q] - termina o programa");
    }
}
