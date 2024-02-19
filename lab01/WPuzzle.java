package lab01;
import java.util.ArrayList;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class WPuzzle {
    
    // [][]
    char[][] puzzleArray;
    ArrayList<String> targets;

    private WPuzzle(char[][] puzzleArray, ArrayList<String> targets){
        this.puzzleArray = puzzleArray;
        this.targets = targets;
    }
    

    public static WPuzzle LoadFromFile(String filename) throws FileNotFoundException{
        Scanner input = new Scanner(new FileReader(filename));
        String line = input.nextLine();
        int cols = line.length();
        int rows = 0;
        ArrayList<ArrayList<char>> puzzleArray = new ArrayList<>();
        String regex = "[A-Z]{" + cols + "}";
        if (!line.matches(regex)){
            input.close();
            return null;
        }
        puzzleArray.add();
        rows++;
        
        while (input.hasNextLine()){
            //While rows < cols, keep reading
            if (rows < cols){
                line = input.nextLine();
                if (line.length() != cols || !line.matches(regex)){
                    input.close();
                    return null;
                }
                puzzleArray.add();
                rows++;
            }
        }
        input.close();
        return null;
    }
}
