package lab01;

public class Main{

    public static void main(String args[]){
        
        WPuzzle puzzle = WPuzzle.LoadFromFile();
        WSSolver wSolver = WSSolver(puzzle);
        
        wSolver.output();

    }
}