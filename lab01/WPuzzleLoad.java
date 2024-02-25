import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class WPuzzleLoad {
    
    public static WPuzzle LoadFromFile(String filename) throws FileNotFoundException{
        Scanner input = new Scanner(new FileReader(filename));
        String line = input.nextLine();
        int cols = line.length();
        int rows = 0;
        char[][] puzzleArray = new char[WPuzzle.MAX_SIZE][WPuzzle.MAX_SIZE]; // the maximum size
        ArrayList<String> targets = new ArrayList<>();
        String regex = "[A-Z]{" + cols + "}";

        if (!line.matches(regex) || cols < 1 || cols > WPuzzle.MAX_SIZE){
            input.close();
            throw new IllegalArgumentException("The maze is invalid.");
        }
        puzzleArray[rows] = line.toCharArray(); 
        rows++;
        
        while (input.hasNextLine()){
            //While rows < cols, keep reading the matrix of characters
            if (rows < cols){
                line = input.nextLine();
                if (line.length() != cols || !line.matches(regex)){
                    input.close();
                    throw new IllegalArgumentException("The maze is invalid.");
                }
                puzzleArray[rows] = line.toCharArray();
                rows++;
            } else {
                // If rows == cols, then we are reading the targets
                // If exists an invalid target, then the file is invalid

                String[] targetLine = input.nextLine().split("[\\s,;.]+"); 
                for (String target : targetLine){
                    if (!isTargetValid(target)){
                        input.close();
                        throw new IllegalArgumentException("The maze is invalid.");
                    }
                    targets.add(target);
                }
            }
        }
        input.close();
        if (rows != cols || targets.size() == 0){
            throw new IllegalArgumentException("The maze is invalid.");
        }
        return new WPuzzle(puzzleArray, targets, rows);
    }

    public static boolean isTargetValid(String target){
        return !target.equals(target.toUpperCase()) && target.matches("^[a-zA-Z]+$");
    }
}
