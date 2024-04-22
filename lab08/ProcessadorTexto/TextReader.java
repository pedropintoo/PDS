package ProcessadorTexto;

import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.Scanner;

public class TextReader implements Filter{

    private Scanner file;

    TextReader(String fileName) throws FileNotFoundException {
        this.file = new Scanner(new FileReader(fileName));
    }

    public boolean hasNext() {
        return file.hasNext();
    }

    public String next() {
        return file.nextLine();
    }
    
}
