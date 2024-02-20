package lab01;

public class Main{

    public static void main(String args[]) throws Exception{
        
        WPuzzle puzzle = WPuzzleLoad.LoadFromFile("./lab01/test.txt");
        
        // // Tests
        // if (puzzle == null){
        //     System.out.println("Invalid puzzle");
        //     return;
        // }
        // System.out.println("Puzzle loaded successfully");
        System.out.println("Puzzle:");
        for (int i = 0; i < puzzle.getRows(); i++){
            for (int j = 0; j < puzzle.getCols(); j++){
                System.out.print(puzzle.getPuzzleArray()[i][j]);
            }
            System.out.println();
        }
        System.out.println("Targets:");
        for (String target : puzzle.getTargets()){
            System.out.println(target);
        }
        System.out.println("---" + puzzle.getPuzzleArray()[2][3]);
        // Point point = new Point(22, 22, 23);
        // //System.out.println(point);
        
        // for (Point near : point.touchingPoints()) {
        //     System.out.println(near);
        // }

        //////////////////////////////////////////////
        WSSolver wSolver = new WSSolver(puzzle);
        wSolver.solve();
        //wSolver.output();

    }
}