package lab01;

public class WSSolver {

    private enum WSState{
        READY,
        SOLVED,
        INVALID
    }
    
    WSState state;
    WPuzzle puzzle;

    public WSSolver(WPuzzle puzzle) {
        this.puzzle = puzzle;
        this.state = WSState.READY;
    }

    public void solve() {
        // Solve the maze
    }


    public void output(){
        // Output of the result after solve the Puzzle

        if (this.state == WSState.READY) {
            System.out.println("Try to solve the WPuzzle first. (solve())");
            return;
        }

        if (this.state == WSState.INVALID) {
            System.out.println("The maze is invalid.");
            return;
        }

        // Output Structure

    }


}
