package lab01;

public class WSOutput {
    public static void output(WSSolver wSolver){
        // Output of the result after solve the Puzzle
        
        WSState state = wSolver.getState();

        if (state == WSState.READY) {
            System.out.println("Try to solve the WPuzzle first. (solve())");
            return;
        }

        if (state == WSState.INVALID) {
            System.out.println("The maze is invalid.");
            return;
        }

        // Output Structure

    }
}
