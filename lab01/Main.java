package lab01;

public class Main{

    public static void main(String args[]){
        WPuzzle puzzle;
        try {
            puzzle = WPuzzleLoad.LoadFromFile("./lab01/test2.txt");
        } catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                System.out.println(e.getMessage());
                return;
            }
            System.out.println("File not found.");
            return;
        }
        WSSolver wSolver = new WSSolver(puzzle);
        wSolver.solve();
        WSOutput.output(wSolver);
    }
}