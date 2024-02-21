package lab01;

import java.util.ArrayList;
import java.util.Map;

public class WSValidator {
    public static boolean validate(WSSolver wSolver) {

        // Validate if every target was found and only one time
        for (Map.Entry<String, ArrayList<Vector>> targetsMap : wSolver.getTargets_map().entrySet()) {
            ArrayList<Vector> list_vectors = targetsMap.getValue();
            int occurrences = list_vectors.size();
            
            if (occurrences == 0 || occurrences > 1) return false;
        }
        return true;

    }
}
