package lab01;

import java.util.Map;

public class WSValidator {
    public static boolean validate(WSSolver wSolver) {

        // Validate if every target was found and only one time
        for (Map.Entry<String, Map<Point, WSDirection>> targetsMap : wSolver.getTargets_map().entrySet()) {
            Map<Point, WSDirection> innerMap = targetsMap.getValue();
            int occurrences = innerMap.size();
            
            if (occurrences == 0) {
                return false;
            } else if (occurrences > 1) {
                return false;
            }
        }
        return true;

    }
}
