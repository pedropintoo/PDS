package lab01;

import java.util.ArrayList;

public class WSSolver {
    
    private WSState state;
    private WPuzzle puzzle;

    public WSSolver(WPuzzle puzzle) {
        this.puzzle = puzzle;
        this.state = WSState.READY;
    }

    // Word Search Solver
    public void solve() {
        for (int i = 0; i < puzzle.getRows(); i++){
            for (int j = 0; j < puzzle.getCols(); j++){
                ArrayList<String> resTargets = getRestrictTargets(puzzle.getPuzzleArray()[i][j]);
                for (String target : resTargets) {
                    Point start = new Point(0,0,puzzle.getCols());
                    if (solveRec(start,WSDirection.RIGHT,target)) {
                        System.out.println(target);
                    }
                }
            }
        }
    }

    // Recursive algorithm to solve
    private boolean solveRec(Point current, WSDirection direction, String target) {
        // stop condition
        if (target.isEmpty()) return true;

        // current = start -> Direction is not defined yet!
        if (direction == null) {
            return false;
        } else {
            Point next = current.touchingPointInDirection(direction);
            if (next == null) return false; // BORDER-CONDITION
            
            // Testing the letter
            int x = next.getX(); 
            int y = next.getY();
            char next_letter = puzzle.getPuzzleArray()[x][y];
            //System.out.println("[--] - " + next_letter);
            if (target.charAt(0) == Character.toLowerCase(next_letter)) {
                // Is the correct letter!
                return solveRec( next, direction, target.substring(1));
            }
        }

        return true;

    }

    private ArrayList<String> getRestrictTargets(char c){
        ArrayList<String> restrict_targets = new ArrayList<>();

        // If the first character of the target string is equal
        // to argument character we add in the ArrayList of Restrict Targets
        for (String str : puzzle.getTargets()) {
            if(str.charAt(0) == Character.toLowerCase(c)) restrict_targets.add(str);
        }
        return restrict_targets;
    }

    public WSState getState() {
        return state;
    }
    

}
