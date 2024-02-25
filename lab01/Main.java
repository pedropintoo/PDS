public class Main{

    public static void main(String args[]){
        WPuzzle puzzle;
        try {
            puzzle = WPuzzleLoad.LoadFromFile(args[0]);
        } catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                System.err.println(e.getMessage());
                return;
            }
            System.err.println("File not found.");
            return;
        }
        WSSolver wSolver = new WSSolver(puzzle);
        wSolver.solve();
        WSOutput.output(wSolver);
    }
}