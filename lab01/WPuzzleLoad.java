package lab01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

// class WPuzzleLoad is a class that reads a file and returns a WPuzzle object
public class WPuzzleLoad {
    
    public static WPuzzle LoadFromFile(String filename) throws FileNotFoundException{
        Scanner input = new Scanner(new FileReader(filename));
        String line = input.nextLine();
        int cols = line.length();
        int rows = 0;
        //ArrayList<ArrayList<char>> puzzleArray = new ArrayList<>();
        char[][] puzzleArray = new char[40][40]; // 40x40 is the maximum size
        ArrayList<String> targets = new ArrayList<>();
        String regex = "[A-Z]{" + cols + "}";

        if (!line.matches(regex) || cols < 1 || cols > 40){
            input.close();
            return null;
        }
        //puzzleArray.add(new ArrayList<char>());
        puzzleArray[rows] = line.toCharArray(); 
        rows++;
        
        while (input.hasNextLine()){
            //While rows < cols, keep reading the matrix of characters
            if (rows < cols){
                line = input.nextLine();
                if (line.length() != cols || !line.matches(regex)){
                    input.close();
                    return null;
                }
                //puzzleArray.add(new ArrayList<char>());
                puzzleArray[rows] = line.toCharArray();
                rows++;
            } else {
                //If rows == cols, then we are reading the targets
                String[] targetLine = input.nextLine().split("[\\s,;.]+"); // Split by any whitespace, comma or semicolon
                for (String target : targetLine){
                    // If the target is not a string of letters, return null
                    if (!target.matches("^[a-zA-Z]+$")){
                        input.close();
                        return null;
                    }
                    targets.add(target);
                }
            }
        }
        input.close();
        return new WPuzzle(puzzleArray, targets, rows, cols);
    }

}
