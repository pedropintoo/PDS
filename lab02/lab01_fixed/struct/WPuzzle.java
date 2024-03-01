/*
 * Created on Mon Feb 26 2024
 *
 * Copyright (c) 2024 - Pedro Pinto (pmap@ua.pt) ; Guilherme Santos (gui.santos91@ua.pt)
 */
package struct;

import java.util.ArrayList;

public class WPuzzle {
    
    public static int MAX_SIZE = 40;
    private char[][] puzzleArray;
    private ArrayList<String> targets;
    private int size;

    public WPuzzle(char[][] puzzleArray, ArrayList<String> targets, int size){
        this.puzzleArray = puzzleArray;
        this.targets = targets;
        this.size = size;
    }

    // Getters

    public char[][] getPuzzleArray(){
        return puzzleArray;
    }

    public ArrayList<String> getTargets(){
        return targets;
    }

    public int getSize(){
        return size;
    }

    public void printPuzzle(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(this.puzzleArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}
