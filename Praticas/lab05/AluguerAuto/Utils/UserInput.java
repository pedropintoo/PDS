/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-03-18
 */

package AluguerAuto.Utils;

import java.util.Scanner;

public class UserInput {
    final private static Scanner sc = new Scanner(System.in);
    public static int IntegerInput(int min, int max, String print) {

        // Inputs
        System.out.print(print);
        double number = sc.nextDouble();

        // Validation
        while (number != (int) number || number < min || number > max) {
            System.out.println("Invalid value!");
            System.out.print(print);
            number = sc.nextDouble();
        }

        //sc.close(); // is not included for loops

        // Return Integer
        return (int) number;
    }

    public static double DoubleInput(double min, double max, String print) {

        // Inputs
        System.out.print(print);
        double number = sc.nextDouble();

        // Validation
        while ( number < min || number > max) {
            System.out.println("Invalid value!");
            System.out.print(print);
            number = sc.nextDouble();
        }

        // sc.close() // is not included for loops

        // Return Double
        return number;
    }

    public static double roundPrecision(double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
}
