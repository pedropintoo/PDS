package lab01;

import java.util.ArrayList;
import java.util.Random;

public class WRandomPuzzle {

    private static final Random RANDOM = new Random();
    private final static int TRIES_BEFORE_RESIGN = (int) 1e10;
    private final static char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public WPuzzle generateRandomPuzzle(ArrayList<String> targets,int size) {
        // simple condition
        if (!isTargetsLengthValid(targets, size)) return null;

        // generate a random puzzle
        char[][] puzzleArray = generateRandomPuzzleArray(size);

        // Try to insert targets in random positions in the puzzle
        puzzleArray = insertTargetsInPuzzle(puzzleArray, targets, size);

        // Check if the puzzle was created
        if (puzzleArray == null) return null;

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                System.out.print(puzzleArray[i][j]);
            }
            System.out.println();
        }

        return new WPuzzle(puzzleArray,targets,size);
    }

    private char[][] insertTargetsInPuzzle(char[][] puzzleArray, ArrayList<String> targets, int size){
        // [Not the best algorithm]
        // Algorithm: We will attempt to insert targets TRIES_BEFORE_RESIGN times in random positions.
        // Therefore, it is a probabilistic algorithm, and success depends on both the input and the value of TRIES_BEFORE_RESIGN.

        Point current = null;
        int n_try = 0;
        int x = 0;
        int y = 0;

        while (true) {   
            if (n_try++ > TRIES_BEFORE_RESIGN) return null; // Failure

            for (String target : targets) {
                x = RANDOM.nextInt(size);
                y = RANDOM.nextInt(size);

                current = new Point(x, y, size);
                puzzleArray[y][x] = target.charAt(0);

                // Chose a direction for the target
                WSDirection direction = WSDirection.randomDirection();

                // Put the remaining characters in the position (try)
                for (int n = 1; n < target.length(); n++) {

                    current = current.getPointInDirection(direction);

                    // Not possible
                    if (current == null) break; // this must be a TRIPLE-BREAK

                    x = current.getX();
                    y = current.getY();

                    puzzleArray[y][x] = target.charAt(n);
                }

                if (current == null) break; // TRIPLE-BREAK
            }  

            if (current == null) continue; // TRIPLE-BREAK

            if(isValidPuzzle(puzzleArray, targets, size)) break; // Success

        }
        
        return puzzleArray;
    }

    private boolean isValidPuzzle(char[][] puzzleArray, ArrayList<String> targets, int size) {
        // Check Valid by solving!

        WSSolver solver = new WSSolver(new WPuzzle(puzzleArray, targets, size));
        solver.solve();
        return solver.getState() == WSState.SOLVED;
    }

    private boolean isTargetsLengthValid(ArrayList<String> targets, int size){
        for (String target : targets) {
            if (target.length() > size) return false;
        }

        return true;
    }

    // Generates a random letter in each cell of puzzle array
    private char[][] generateRandomPuzzleArray(int size) {
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