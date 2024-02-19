package lab01;
import java.util.ArrayList;

public class WPuzzle {
    
    private char[][] puzzleArray;
    private ArrayList<String> targets;
    private int cols;
    private int rows;

    public WPuzzle(char[][] puzzleArray, ArrayList<String> targets, int rows, int cols){
        this.puzzleArray = puzzleArray;
        this.targets = targets;
        this.rows = rows;
        this.cols = cols;
    }

    public char[][] getPuzzleArray(){
        return puzzleArray;
    }

    public ArrayList<String> getTargets(){
        return targets;
    }

    public int getCols(){
        return cols;
    }

    public int getRows(){
        return rows;
    }

}
