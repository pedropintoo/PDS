/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-03-09
 */

public class Utils {
    public static boolean isAlphaNumeric(String str) {
        return str.matches("[a-zA-Z][a-zA-Z0-9]*");
    }
    public static boolean isIntegerXInteger(String str) {
        return str.matches("[1-9][0-9]*x[1-9][0-9]*");
    }
    public static boolean isSeatPossible(int[][] seatsArray, int rows, int cols, int i, int j){
        return j + i/rows < cols && seatsArray[i % rows][j+i/rows] == 0;
    }
}
