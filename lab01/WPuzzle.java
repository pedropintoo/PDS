package lab01;
import java.util.ArrayList;

public class WPuzzle {
    
    public static int MAX_SIZE = 40;
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

    public static void printPuzzle(char[][] puzzleArray ,int size){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(puzzleArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printPuzzleWithoutSpace(char[][] puzzleArray ,int size){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(puzzleArray[i][j]);
            }
            System.out.println();
        }
    }
}
