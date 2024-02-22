package lab01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WSSolver {
    
    private WSState state;
    private WPuzzle puzzle;

    private final Map<String,ArrayList<Vector>> targets_map;

    public WSSolver(WPuzzle puzzle) {
        this.puzzle = puzzle;
        this.state = WSState.READY;

        // Initialize the structure that holds the results
        this.targets_map = new HashMap<>();
        for (String target : puzzle.getTargets()) {
            targets_map.put(target, new ArrayList<>());
        }
    }

    // Word Search Solver
    // Base method
    public void solve() {
        
        state = WSState.INVALID;
        /////////////////////
        // Start the Solver
        /////////////////////

        for (int y = 0; y < puzzle.getSize(); y++){
            for (int x = 0; x < puzzle.getSize(); x++){
                ArrayList<String> resTargets = getRestrictTargets(puzzle.getPuzzleArray()[y][x]);
                for (String target : resTargets) {
                    Point start = new Point(x,y,puzzle.getSize());

                    // We pass the full target because of the mapping 
                    // but we already check the first char!
                    solveRec(start,null,target);
                    
                }
            }
        }

        // Validations 
        if (WSValidator.validate(this)) state = WSState.SOLVED;
    }

    // Recursive algorithm to solve
    private boolean solveRec(Point current, WSDirection direction, String target) {
        // stop condition
        if (target.isEmpty()) return true;
        
        if (direction == null) {
            // Direction is not defined yet!
            // So, test all directions
            for (WSDirection dir : WSDirection.values()) {
                Point next = current.getPointInDirection(dir);
                if (next == null) continue; // BORDER-CONDITION

                // Testing the letter
                int x = next.getX(); 
                int y = next.getY();
                char next_letter = puzzle.getPuzzleArray()[y][x];
                
                // (remember: we already test the first char!) 
                if (Character.toLowerCase(target.charAt(1)) == Character.toLowerCase(next_letter)) {
                    // Is the correct letter!
                    // So, change the direction
                    if(solveRec(next, dir, target.substring(2))) {
                        ArrayList<Vector> list_vector = targets_map.get(target);
                        list_vector.add(new Vector(current, dir, target.length()));
                    }
                }
            }

        } else {
            // Direction is already defined!
            Point next = current.getPointInDirection(direction);
            if (next == null) return false; // BORDER-CONDITION
            
            // Testing the letter
            int x = next.getX(); 
            int y = next.getY();
            char next_letter = puzzle.getPuzzleArray()[y][x];

            if (Character.toLowerCase(target.charAt(0)) == Character.toLowerCase(next_letter)) {
                // Is the correct letter!
                // 
                return solveRec( next, direction, target.substring(1));
            }
        }

        return false;

    }

    private ArrayList<String> getRestrictTargets(char c){
        ArrayList<String> restrict_targets = new ArrayList<>();

        // If the first character of the target string is equal
        // to argument character we add in the ArrayList of Restrict Targets
        for (String str : puzzle.getTargets()) {
            if(Character.toLowerCase(str.charAt(0)) == Character.toLowerCase(c)) restrict_targets.add(str);
        }
        return restrict_targets;
    }

    // Getters

    public WSState getState() {
        return state;
    }

    public Map<String, ArrayList<Vector>> getTargets_map() {
        return targets_map;
    }

    

}
