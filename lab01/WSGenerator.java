import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class WSGenerator {

    private static int size = 0;
    private static ArrayList<String> targets = null;
    private static String fileOfTargets = null;
    private static PrintStream ps = System.out;

    public static void main(String[] args) {

        readArgs(args);

        validateArgs();
        
        WPuzzle puzzle = WRandomPuzzle.generateRandomPuzzle(targets, size);

        if (puzzle == null) {
            error();
        }
        // Output in printStream
        printOutput(puzzle);

    }

    private static void printOutput(WPuzzle puzzle) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                ps.print(puzzle.getPuzzleArray()[i][j]);
            }
            ps.println();
        }
        printTargets();
    }

    private static void printTargets() {
        Scanner sc;
        try {
            sc = new Scanner(new FileReader(fileOfTargets));
        } catch (Exception e) {
            System.err.println("File not found.");
            return;
        }
        while (sc.hasNextLine()) {
            ps.println(sc.nextLine());
        }
        sc.close();
    }

    private static void validateArgs() {
        if (targets == null || size == 0 || size > WPuzzle.MAX_SIZE || ps == null) {
            error();
        }
    }

    private static void readArgs(String[] args) {

        // each argument need a value
        if (args.length % 2 != 0) return;

        for (int i = 0; i < args.length; i++) {
            String current_arg = args[i];
            switch (current_arg) {
                case "-i":
                    // file for targets
                    fileOfTargets = args[++i];
                    targets = readTargets(fileOfTargets);
                    break;
                case "-s":
                    // size 
                    size = Integer.parseInt(args[++i]);
                    break; 
                case "-o":
                    // output stream
                    try {
                        ps = new PrintStream(args[++i]); 
                    } catch (Exception e) {
                        System.err.println("File not found.");
                        return;
                    }     
                    break;       
                default:
                    error();
            }
        }
    }

    private static void error() {
        System.err.println(getArgStructure());
        System.exit(1);
    }

    private static String getArgStructure() {
        return "Args: <-i:targetsFile> <-s:size>";
    }

    private static ArrayList<String> readTargets(String fileOfTargets) {
        Scanner input;
        try {
            input = new Scanner(new FileReader(fileOfTargets));
        } catch (Exception e) {
            System.err.println("File not found.");
            return null;
        }
        ArrayList<String> targetsList = new ArrayList<>();

        while (input.hasNextLine()){

            String[] targetLine = input.nextLine().split("[\\s,;.]+"); 
            for (String target : targetLine){
                if (!WPuzzleLoad.isTargetValid(target)){
                    input.close();
                    return null;
                }
                targetsList.add(target);
            }
        }
        
        input.close();
        return targetsList;
    }



}
