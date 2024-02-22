package lab01;
import java.util.ArrayList;

public class WPuzzle {
    
    private char[][] puzzleArray;
    private ArrayList<String> targets;
    private int size;

    public WPuzzle(char[][] puzzleArray, ArrayList<String> targets, int size){
        this.puzzleArray = puzzleArray;
        this.targets = targets;
        this.size = size;
    }

    // Getters

    public char[][] getPuzzleArray(){
        return puzzleArray;
    }

    public ArrayList<String> getTargets(){
        return targets;
    }

    public int getSize(){
        return size;
    }


}
