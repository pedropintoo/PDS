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

        System.out.println("\n\n---- NormalizationFilter ----");
        reader = new NormalizationFilter(new TextReader("text.txt"));
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
