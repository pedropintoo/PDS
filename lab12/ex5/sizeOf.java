/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-22
 */
package ex5;

import java.io.IOException;
import java.nio.file.*;

public class sizeOf {
    public static void main(String[] args) throws IOException {
        Path startingDir;
        boolean recursive = false;
        if (args.length == 2) {
            recursive = args[0].equals("-r");
            startingDir = Paths.get(args[1]);
        } else {
            startingDir = Paths.get(args[0]);
        }
        
        SizeCalculator calculator = new SizeCalculator(recursive, startingDir);
        Files.walkFileTree(startingDir, calculator);
        
        calculator.printSizes(startingDir);
    }
}
