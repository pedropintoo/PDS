package lab01;

import java.util.ArrayList;

public class WSGenerator {
    public static void main(String[] args) {
        
        String file = args[0];
        int size = args[1];

        ArrayList<String> targets = new ArrayList<>();
        targets.add("programming");

        WPuzzle puzzle = new WPuzzle(puzzleArray,targets,size,size);
        

    }
}
