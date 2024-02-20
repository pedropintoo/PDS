package lab01;

import java.util.ArrayList;

public class WSSolver {
    
    private WSState state;
    private WPuzzle puzzle;
    private ArrayList<String> targets;

    public WSSolver(WPuzzle puzzle) {
        this.puzzle = puzzle;
        this.state = WSState.READY;
        this.targets = puzzle.getTargets();
    }

    // Word Search Solver
    public void solve() {
        for (int i = 0; i < puzzle.getRows(); i++){
            for (int j = 0; j < puzzle.getCols(); j++){
                System.out.print(puzzle.getPuzzleArray()[i][j]);
            }

            System.out.println();
        }
        
        Point start = new Point(0, 0, puzzle.getRows());
        solveRec(start, null, word);
        // Solve the maze
        for (int i = 0; i < puzzle.getRows(); i++){
            for (int j = 0; j < puzzle.getCols(); j++){
                System.out.print(puzzle.getPuzzleArray()[i][j]);
            }

            System.out.println();
        }
    }
    
    private ArrayList<String> getRestrictTargets(char c){
        ArrayList<String> restrict_targets = new ArrayList<>();

        // If the first character of the target string is equal
        // to argument character we add in the ArrayList of Restrict Targets
        for (String str : targets) {
            if(str.charAt(0) == c) restrict_targets.add(str);
        }
        return restrict_targets;
    }

    // Recursive algorithm to solve
    private void solveRec() {
        
        for (int i = 0; i < puzzle.getRows(); i++){
            for (int j = 0; j < puzzle.getCols(); j++){
                System.out.print(puzzle.getPuzzleArray()[i][j]);
            }

            System.out.println();
        }
    }

    public WSState getState() {
        return state;
    }
    

}
