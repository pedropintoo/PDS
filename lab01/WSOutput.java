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
        for (String key : targets_map.keySet()) {
            ArrayList<Vector> innerMap = targets_map.get(key);
            Vector vector = innerMap.get(0); // if the puzzle is valid, the target will be found only once
            Point root = vector.getRoot();
            WSDirection direction = vector.getDirection();
            int size = vector.getSize();

            System.out.printf("%-16s%-7d%-10s%-15s", key, size, root, direction);
            System.out.println();
        }
                
    }
}
