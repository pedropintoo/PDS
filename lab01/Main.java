package lab01;

public class Main{

    public static void main(String args[]){
        
        WPuzzle puzzle = WPuzzle.LoadFromFile("file");
        WSSolver wSolver = new WSSolver(puzzle);
        wSolver.solve();
        wSolver.output();

    }
}