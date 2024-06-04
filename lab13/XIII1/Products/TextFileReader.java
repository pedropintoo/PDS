package Products;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFileReader implements ProductsReader {
    private String file;

    public TextFileReader(String file) {
        this.file = file;
    }

    @Override
    public List<Product> importFromProductsReader() {
        List<Product> importedList = new ArrayList<>();
        Scanner sc;
        try {
            sc = new Scanner(new FileReader(this.file));
        }
        catch(FileNotFoundException e) {
            System.err.println("ERROR -> " + e);
            return importedList;
        }
        
        String line;
        String[] attrs;

        while (sc.hasNextLine()) {
            line = sc.nextLine();
            attrs = line.split("\t");
            
            // switching type
            switch(attrs[0].trim()) {
                case "Car":
                    importedList.add(new Car(attrs[1], attrs[2], Double.parseDouble(attrs[3])));
                    break;
                case "Van":
                    importedList.add(new Van(attrs[1], attrs[2], Double.parseDouble(attrs[3])));
                    break;
                case "Motorcycle":
                    importedList.add(new Motorcycle(attrs[1], attrs[2], Double.parseDouble(attrs[3])));
                    break;
                case "Jeep":
                    importedList.add(new Jeep(attrs[1], attrs[2], Double.parseDouble(attrs[3])));
                    break;
            }


        }
        sc.close();

        return importedList;

    }
    
}
