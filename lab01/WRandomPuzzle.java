package lab01;

import java.util.ArrayList;
import java.util.Random;

public class WRandomPuzzle {

    private static final Random RANDOM = new Random();
    private final static int TRIES_BEFORE_RESIGN = (int) 1e10;
    private final static char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static WPuzzle generateRandomPuzzle(ArrayList<String> targets,int size) {
        // [Not the best algorithm]
        // Algorithm: We will attempt to insert targets TRIES_BEFORE_RESIGN times in random positions.
        // Therefore, it is a probabilistic algorithm, and success depends on both the input and the value of TRIES_BEFORE_RESIGN.

        // simple condition
        if (!isTargetsLengthValid(targets, size)) return null;

        // Try to insert targets in random positions in a random puzzle
        char[][] puzzleArray = insertTargetsInPuzzle(targets, size);

        // Check if the puzzle was created
        if (puzzleArray == null) return null;

        return new WPuzzle(puzzleArray,targets,size);
    }

    private static char[][] insertTargetsInPuzzle(ArrayList<String> targets, int size){

        char[][] puzzleArray = null;
        Point current = null;
        int n_try = 0;
        int x = 0;
        int y = 0;

        while (true) {   
            if (n_try++ > TRIES_BEFORE_RESIGN) return null; // Failure
            
            // generate a random puzzle
            puzzleArray = generateRandomPuzzleArray(size);

            // Try to fill with all the targets
            for (String target : targets) {
                x = RANDOM.nextInt(size);
                y = RANDOM.nextInt(size);

                current = new Point(x, y, size);
                puzzleArray[y][x] = Character.toUpperCase(target.charAt(0));

                // Chose a direction for the specific target
                WSDirection direction = WSDirection.randomDirection();

                // Put the remaining characters in the direction (try)
                for (int n = 1; n < target.length(); n++) {

                    current = current.getPointInDirection(direction);

                    // Not possible
                    if (current == null) break; // this must be a TRIPLE-BREAK

                    x = current.getX();
                    y = current.getY();

                    puzzleArray[y][x] = Character.toUpperCase(target.charAt(n));
                }

                if (current == null) break; // TRIPLE-BREAK
            }  

            if (current == null) continue; // TRIPLE-BREAK

            if(isValidPuzzle(puzzleArray, targets, size)) break; // Success

        }
        
        return puzzleArray;
    }

    private static boolean isValidPuzzle(char[][] puzzleArray, ArrayList<String> targets, int size) {
        // Check Valid by solving!

        WSSolver solver = new WSSolver(new WPuzzle(puzzleArray, targets, size));
        solver.solve();
        return solver.getState() == WSState.SOLVED;
    }

    private static boolean isTargetsLengthValid(ArrayList<String> targets, int size){
        for (String target : targets) {
            if (target.length() > size) return false;
        }

        return true;
    }

    // Generates a random letter in each cell of puzzle array
    private static char[][] generateRandomPuzzleArray(int size) {
        char[][] puzzleArray = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int randIdx = RANDOM.nextInt(letters.length);
                puzzleArray[i][j] = letters[randIdx];
            }
        }

        return puzzleArray;
    }

}