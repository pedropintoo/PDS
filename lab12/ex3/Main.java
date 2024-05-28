package ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Java Anti-Stress", 2024, "Omodionah");
        Book book2 = new Book("A Guerra dos Padrões", 2024, "Jorge Omel");
        Book book3 = new Book("A Procura da Luz", 2024, "Khumatkli");
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        while (true) {
            System.out.println("*** Library ***");
            for (Book book : books) {
                System.out.println(book);
            }
            System.out.println(">> <book>, <operation: (1)register, (2)require, (3)return, (4)reserve, (5)cancel (6)quit>");

            System.out.print(">> ");
            Scanner scanner = new Scanner(System.in);
            String[] input = scanner.nextLine().split(",");
            int bookISBN = Integer.parseInt(input[0]);
            int operation = Integer.parseInt(input[1]);

            if (operation == 6) {
                scanner.close();
                break;
            }

            // Book exists?
            Book book = books.stream().filter(b -> b.getISBN() == bookISBN).findFirst().orElse(null);
            if (book == null) {
                System.out.println("Book not found");
                continue;
            }
            else {
                switch (operation) {
                    case 1:
                        book.registerBook();
                        break;
                    case 2:
                        book.requireBook();
                        break;
                    case 3:
                        book.returnBook();
                        break;
                    case 4:
                        book.reserveBook();
                        break;
                    case 5:
                        book.cancelBook();
                        break;
                    default:
                        System.out.println("Invalid operation");
                        break;
                }
            }
        }
    }
}
