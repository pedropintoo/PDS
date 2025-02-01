/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-19
 */

package Impressora;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Document {

    private Scanner fp;
    private String filename;

    public Document(String filename) {
        this.filename = filename;
        try {
            this.fp = new Scanner(new FileReader(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean hasNextLine() {
        return fp.hasNextLine();
    }

    public String readLine() {
        return fp.nextLine();
    }

    public void reopen() {
        try {
            this.fp.close();
            this.fp = new Scanner(new FileReader(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
