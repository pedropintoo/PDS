/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-22
 */

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
