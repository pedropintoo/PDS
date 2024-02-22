package lab01;

import java.util.ArrayList;
import java.util.Map;

public class WSValidator {
    public static boolean validate(WSSolver wSolver) {
        filter(wSolver);
        // Validate if every target was found and only one time
        for (Map.Entry<String, ArrayList<Vector>> targetsMap : wSolver.getTargets_map().entrySet()) {
            ArrayList<Vector> list_vectors = targetsMap.getValue();
            int occurrences = list_vectors.size();
            
            if (occurrences == 0 || occurrences > 1) return false;
        }
        return true;

    }

    public static void filter(WSSolver wsSolver){
        Map<String, ArrayList<Vector>> targets_map = wsSolver.getTargets_map();

        for (String target : targets_map.keySet()){
            for (String targetToCompare : targets_map.keySet()){
                if (isTargetToCompareCandidate(target, targetToCompare)){
                    ArrayList<Vector> targetVector = targets_map.get(target);
                    ArrayList<Vector> targetToCompareVector = targets_map.get(targetToCompare);

                    removeInvalidPoints(targetVector, targetToCompareVector);                    
                }
            }
        } 
    }

    public static boolean isTargetToCompareCandidate(String target, String targetToCompare){
        return !target.equals(targetToCompare) && targetToCompare.contains(target);
    }

    public static void removeInvalidPoints(ArrayList<Vector> targetVector, ArrayList<Vector> targetToCompareVector){
        // TODO
    }
    
}
