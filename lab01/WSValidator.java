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
                    ArrayList<Vector> targetVectors = targets_map.get(target);
                    ArrayList<Vector> targetToCompareVectors = targets_map.get(targetToCompare);

                    removeInvalidPoints(targetVectors, targetToCompareVectors);                    
                }
            }
        } 
    }

    public static boolean isTargetToCompareCandidate(String target, String targetToCompare){
        return !target.equals(targetToCompare) && targetToCompare.contains(target);
    }

    public static void removeInvalidPoints(ArrayList<Vector> targetVectors, ArrayList<Vector> targetToCompareVectors){
        for (int i = 0; i < targetVectors.size(); i++){
            Vector targetVector = targetVectors.get(i);
            for (int j = 0; j < targetToCompareVectors.size(); j++){
                Vector targetToCompareVector = targetToCompareVectors.get(j);
                if (isTargetInBetween(targetVector, targetToCompareVector)){
                    targetVectors.remove(i);
                    i--;
                    break;
                }
            }
        }
    }

    public static boolean isTargetInBetween(Vector targetVector, Vector targetToCompareVector){
        if (targetVector.getDirection().equals(targetToCompareVector.getDirection())){
            Point targetRoot = targetVector.getRoot();
            Point targetToCompareRoot = targetToCompareVector.getRoot();
            int targetSize = targetVector.getSize();
            int targetToCompareSize = targetToCompareVector.getSize();
            switch(targetVector.getDirection()){
                case UP:
                    return targetRoot.getY() <= targetToCompareRoot.getY() && targetRoot.getY() - targetSize >= targetToCompareRoot.getY() - targetToCompareSize;
                case RIGHT_UP:
                    // TODO
                case RIGHT:
                    return targetRoot.getX() >= targetToCompareRoot.getX() && targetRoot.getX() + targetSize <= targetToCompareRoot.getX() + targetToCompareSize;
                case RIGHT_DOWN:
                    // TODO
                case DOWN:
                    return targetRoot.getY() >= targetToCompareRoot.getY() && targetRoot.getY() + targetSize <= targetToCompareRoot.getY() + targetToCompareSize;
                case LEFT_DOWN:
                    // TODO
                case LEFT:
                    return targetRoot.getX() <= targetToCompareRoot.getX() && targetRoot.getX() - targetSize >= targetToCompareRoot.getX() - targetToCompareSize;
                case LEFT_UP:
                    // TODO
            }
            
        }
        return false;
    }  
    
}
