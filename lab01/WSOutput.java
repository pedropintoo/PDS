package lab01;

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
        for (Map.Entry<String, Map<Point, WSDirection>> entry : wSolver.getTargets_map().entrySet()) {
            String key = entry.getKey();
            Map<Point, WSDirection> innerMap = entry.getValue();

            System.out.println("Target: " + key);

            for (Map.Entry<Point, WSDirection> innerEntry : innerMap.entrySet()) {
                Point innerKey = innerEntry.getKey();
                WSDirection value = innerEntry.getValue();

                System.out.println("    " + innerKey + " -> " + value);
            }

            System.out.println();
        }
    
    }
}
