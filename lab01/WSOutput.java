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
        // [FALTA]
        for (Map.Entry<String, ArrayList<Vector>> entry : wSolver.getTargets_map().entrySet()) {
            String key = entry.getKey();
            ArrayList<Vector> innerMap = entry.getValue();

            System.out.println("Target: " + key);

            for (Vector vector : innerMap) {

                System.out.println("    " + vector);
            }

            System.out.println();
        }
    
    }
}
