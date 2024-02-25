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

    private static void filter(WSSolver wsSolver){
        Map<String, ArrayList<Vector>> targets_map = wsSolver.getTargets_map();

        for (String target : targets_map.keySet()){
            for (String targetToCompare : targets_map.keySet()){
                if (isTargetToCompareCandidate(target, targetToCompare)){
                    ArrayList<Vector> targetVectors = targets_map.get(target);
                    ArrayList<Vector> targetToCompareVectors = targets_map.get(targetToCompare);

                    removeInvalidPoints(targetVectors, targetToCompareVectors);                    
                }
            }
            if (isPalindrome(target)){
                // After removing the invalid points, if the target is a palindrome, we remove the reversed vector
                // Its only removed the second one because we assume that the target was found only once
                // And, if it was found more than once, that case will be checked after in the validate method
                ArrayList<Vector> targetVectors = targets_map.get(target);
                // invalid puzzle can have 0 founds 
                if (targetVectors.size() != 0) targetVectors.remove(1); 
            }
        } 
    }

    private static boolean isTargetToCompareCandidate(String target, String targetToCompare){
        return !target.equals(targetToCompare) && targetToCompare.contains(target);
    }

    private static void removeInvalidPoints(ArrayList<Vector> targetVectors, ArrayList<Vector> targetToCompareVectors){
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

    private static boolean isTargetInBetween(Vector targetVector, Vector targetToCompareVector){
        if (targetVector.getDirection().equals(targetToCompareVector.getDirection())){
            Point targetRoot = targetVector.getRoot();
            Point targetToCompareRoot = targetToCompareVector.getRoot();
            Point endTarget = Point.getEndPoint(targetRoot, targetVector.getDirection(), targetVector.getSize());
            Point endTargetToCompare = Point.getEndPoint(targetToCompareRoot, targetToCompareVector.getDirection(), targetToCompareVector.getSize());
            switch(targetVector.getDirection()){
                case UP:
                    return targetRoot.getY() <= targetToCompareRoot.getY() && endTarget.getY() >= endTargetToCompare.getY();
                case RIGHT_UP:
                    return targetRoot.getX() >= targetToCompareRoot.getX() && endTarget.getX() <= endTargetToCompare.getX() && 
                    targetRoot.getY() <= targetToCompareRoot.getY() && endTarget.getY() >= endTargetToCompare.getY();
                case RIGHT:
                    return targetRoot.getX() >= targetToCompareRoot.getX() && endTarget.getX() <= endTargetToCompare.getX();
                case RIGHT_DOWN:
                    return targetRoot.getX() >= targetToCompareRoot.getX() && endTarget.getX() <= endTargetToCompare.getX() &&
                    targetRoot.getY() >= targetToCompareRoot.getY() && endTarget.getY() <= endTargetToCompare.getY();
                case DOWN:
                    return targetRoot.getY() >= targetToCompareRoot.getY() && endTarget.getY() <= endTargetToCompare.getY();
                case LEFT_DOWN:
                    return targetRoot.getX() <= targetToCompareRoot.getX() && endTarget.getX() >= endTargetToCompare.getX() &&
                    targetRoot.getY() >= targetToCompareRoot.getY() && endTarget.getY() <= endTargetToCompare.getY();
                case LEFT:
                    return targetRoot.getX() <= targetToCompareRoot.getX() && endTarget.getX() >= endTargetToCompare.getX();
                case LEFT_UP:
                    return targetRoot.getX() <= targetToCompareRoot.getX() && endTarget.getX() >= endTargetToCompare.getX() &&
                    targetRoot.getY() <= targetToCompareRoot.getY() && endTarget.getY() >= endTargetToCompare.getY();
            }     
        }
        return false;
    }  

    private static boolean isPalindrome(String target){
        int length = target.length();
        for (int i = 0; i < length/2; i++){
            if (target.charAt(i) != target.charAt(length - i - 1)) return false;
        }
        return true;
    }
}
