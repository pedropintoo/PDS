package lab01;

import java.util.Map;

public class WSValidator {
    public static void validate(WSSolver wSolver) {

        // Validate if every target was found and only one time
        for (Map.Entry<String, Map<Point, WSDirection>> targetsMap : wSolver.getTargets_map().entrySet()) {
            Map<Point, WSDirection> innerMap = targetsMap.getValue();
            int occurrences = innerMap.size();
            
            if (occurrences == 0) {
                System.err.println("Target " + targetsMap.getKey() + " not found");
                System.exit(1);
            } else if (occurrences > 1) {
                System.err.println("Target " + targetsMap.getKey() + " found " + occurrences + " times");
                System.exit(1);
            }
        }

    }
}
