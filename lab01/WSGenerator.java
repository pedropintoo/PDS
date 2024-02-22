package lab01;

import java.util.ArrayList;
import java.util.Random;

public class WSGenerator {

    
    public static void main(String[] args) {
        
        String file = args[0];
        int size = Integer.parseInt(args[1]);

        ArrayList<String> targets = new ArrayList<>();
        targets.add("programming");
        targets.add("flask");
        targets.add("zzzzzzzzz");
        targets.add("zzzaaaazzz");

        WPuzzle puzzle = WRandomPuzzle.generateRandomPuzzle(targets, size);

        System.out.println("Puzzle:");
        for (int i = 0; i < puzzle.getSize(); i++){
            for (int j = 0; j < puzzle.getSize(); j++){
                System.out.print(puzzle.getPuzzleArray()[i][j]);
            }
            System.out.println();
        }


    }



}
