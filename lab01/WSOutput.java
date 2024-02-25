public class WSOutput {
    public static void output(WSSolver wSolver){
        // Output of the result after solve the Puzzle
        
        WSState state = wSolver.getState();

        switch (state) {
            case READY:
                System.out.println("Try to solve the WPuzzle first. (solve())");
                break;
            case INVALID:
                System.out.println("The maze is invalid.");
                break;
            case SOLVED:
                wSolver.printSolvedPuzzle();
                break;
        }
    }
}
