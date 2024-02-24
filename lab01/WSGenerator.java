package lab01;

import java.util.ArrayList;

public class WSGenerator {

    private static int size = 0;
    private static ArrayList<String> targets = null;
    
    public static void main(String[] args) {
        
        readArgs(args);
        validateArgs();
        
        WPuzzle puzzle = WRandomPuzzle.generateRandomPuzzle(targets, size);

        if (puzzle == null) {
            System.err.println("Puzzle can't be generated!");
            System.exit(1);
        }

        System.out.println("Puzzle:");
        for (int i = 0; i < puzzle.getSize(); i++){
            for (int j = 0; j < puzzle.getSize(); j++){
                System.out.print(puzzle.getPuzzleArray()[i][j]);
            }
            System.out.println();
        }


    }

    private static void validateArgs() {
        if (targets == null || size == 0 || size > WPuzzle.MAX_SIZE) {
            System.err.println(getArgStructure());
            System.exit(1);
        }
    }

    private static void readArgs(String[] args) {

        for (int i = 0; i < args.length; i++) {
            String current_arg = args[i];
            switch (current_arg) {
                case "-i":
                    String fileOfTargets = args[++i];
                    targets = readTargets(fileOfTargets);
                    break;
                case "-s":
                    size = Integer.parseInt(args[++i]);
                    break;    
                default:
                    System.err.println(getArgStructure());
                    System.exit(1);
            }
        }
    }

    private static String getArgStructure() {
        return "Args: <-i:targetsFile> <-s:size>";
    }

    private static ArrayList<String> readTargets(String fileOfTargets) {
        ArrayList<String> targetsList = new ArrayList<>();
        targetsList.add("zzzzzzzzzz");
        return targetsList;
    }



}
