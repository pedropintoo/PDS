package lab01;
import java.util.ArrayList;

public class WPuzzle {
    
    ArrayList<ArrayList<Character>> puzzleArray;
    ArrayList<String> targets;

    private WPuzzle(ArrayList<ArrayList<Character>> puzzleArray, ArrayList<String> targets){
        this.puzzleArray = puzzleArray;
        this.targets = targets;
    }
    
    public static WPuzzle LoadFromFile(String fileName){
        return null;
    }

}
