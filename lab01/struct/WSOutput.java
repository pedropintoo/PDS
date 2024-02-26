/*
 * Created on Mon Feb 26 2024
 *
 * Copyright (c) 2024 - Pedro Pinto (pmap@ua.pt) ; Guilherme Santos (gui.santos91@ua.pt)
 */
package struct;

import src.WSSolver;
import utils.WSState;

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
