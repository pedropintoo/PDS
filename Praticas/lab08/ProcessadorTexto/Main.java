/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-22
 */

package ProcessadorTexto;

import java.io.FileNotFoundException;

public class Main {
    
    public static void main(String[] args) throws FileNotFoundException {
        Filter reader;

        System.out.println("\n\n---- TextReader ----");
        reader = new TextReader("text.txt");
        while (reader.hasNext()) {
            System.out.println("next: " + reader.next());
        }

        System.out.println("\n\n---- TermFilter ----");
        reader = new TermFilter(new TextReader("text.txt"));
        while (reader.hasNext()) {
            System.out.println("next: " + reader.next());
        }

        System.out.println("\n\n---- NormalizationFilter ----");
        reader = new NormalizationFilter(new TextReader("text.txt"));
        while (reader.hasNext()) {
            System.out.println("next: " + reader.next());
        }

        System.out.println("\n\n---- VowelFilter ----");
        reader = new VowelFilter(new TextReader("text.txt"));
        while (reader.hasNext()) {
            System.out.println("next: " + reader.next());
        }

        System.out.println("\n\n---- CapitalizationFilter ----");
        reader = new CapitalizationFilter(new TextReader("text.txt"));
        while (reader.hasNext()) {
            System.out.println("next: " + reader.next());
        }

        System.out.println("\n\n---- TermFilter & Capitalization & VowelFilter ----");
        reader = new VowelFilter(new CapitalizationFilter(new TermFilter(new TextReader("text.txt")))); 

        while (reader.hasNext()) {
            System.out.println("next: " + reader.next());
        }
    }
}
