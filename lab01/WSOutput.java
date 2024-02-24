package lab01;

import java.util.ArrayList;
import java.util.Map;

public class WSOutput {
    public static void output(WSSolver wSolver){
        // Output of the result after solve the Puzzle
        
        WSState state = wSolver.getState();

        if (state == WSState.READY) {
            System.out.println("Try to solve the WPuzzle first. (solve())");
            return;
        }

        if (state == WSState.INVALID) {
            System.out.println("The maze is invalid.");
            return;
        }

        // Output Structure
        Map<String, ArrayList<Vector>> targets_map = wSolver.getTargets_map();
        for (String target : targets_map.keySet()) {
            ArrayList<Vector> innerMap = targets_map.get(target);
            Vector vector = innerMap.get(0); // if the puzzle is valid, the target will be found only once
            Point root = vector.getRoot();
            WSDirection direction = vector.getDirection();
            int size = vector.getSize();

            System.out.printf("%-16s%-7d%-10s%-15s", target, size, root, direction);
            System.out.println();
        }
        printSolvedPuzzle(wSolver);
    }

    private static void printSolvedPuzzle(WSSolver wSolver) {
        char[][] puzzleArray = initializePuzzleArray(wSolver);
        
        // fill the puzzle array with the found targets
        Map<String, ArrayList<Vector>> targets_map = wSolver.getTargets_map();
        for (String target : targets_map.keySet()){
            for (int i = 0; i < targets_map.get(target).size(); i++){
                Vector vector = targets_map.get(target).get(i);
                Point root = vector.getRoot();
                WSDirection direction = vector.getDirection();
                int sizeVector = vector.getSize();
                for (int j = 0; j < sizeVector; j++){
                    puzzleArray[root.getY()][root.getX()] = Character.toUpperCase(target.charAt(j));
                    root = root.getPointInDirection(direction);
                }
            }
        }
        System.out.println();
        WPuzzle.printPuzzle(puzzleArray, wSolver.getPuzzle().getSize());
    }

    private static char[][] initializePuzzleArray(WSSolver wSolver) {
        // initialize a blank puzzle array (with '.')
        char[][] puzzleArray = wSolver.getPuzzle().getPuzzleArray();
        int size = wSolver.getPuzzle().getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                puzzleArray[i][j] = '.';
            }
        }
        return puzzleArray;
    }
}
