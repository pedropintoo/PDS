package lab01;

public class WSSolver {
    
    WSState state;
    WPuzzle puzzle;

    public WSSolver(WPuzzle puzzle) {
        this.puzzle = puzzle;
        this.state = WSState.READY;
    }

    public void solve() {
        // Solve the maze
    }

    public WSState getState() {
        return state;
    }
    

}
