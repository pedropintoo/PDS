/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-03-04
 */

public class JGaloImplementation implements JGaloInterface {

    private static char[][] tableTicTacToe = new char[3][3];
    private static boolean isPlayerX = false;
    private static char DEFAULT_CELL = ' ';
    private static int playCounter = 0;

    public JGaloImplementation() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tableTicTacToe[i][j] = DEFAULT_CELL;
            }
        }
    }

    public char getActualPlayer(){
        isPlayerX = !isPlayerX;
        return isPlayerX ? 'X' : 'O';
    }

    public boolean setJogada(int lin, int col){
        if (tableTicTacToe[lin-1][col-1] == DEFAULT_CELL) {
            tableTicTacToe[lin-1][col-1] = isPlayerX ? 'X' : 'O';
            playCounter++;
            return true;
        }
        return false;
    }

    public boolean isFinished() {
        return checkResult() != DEFAULT_CELL || playCounter == 9;
    }

    public char checkResult(){
        char result = checkLineWin();
        if (result != DEFAULT_CELL) {
            return result;
        }
        return checkDiagonalWin();
    }

    private char checkLineWin() {
        for (int i = 0; i < 3; i++) {
            char firstHorizontalCell = tableTicTacToe[i][0];
            char firstVerticalCell = tableTicTacToe[0][i];
            if (firstHorizontalCell != DEFAULT_CELL && firstHorizontalCell == tableTicTacToe[i][1] && firstHorizontalCell == tableTicTacToe[i][2] ||
                firstVerticalCell != DEFAULT_CELL && firstVerticalCell == tableTicTacToe[1][i] && firstVerticalCell == tableTicTacToe[2][i]) {
                return tableTicTacToe[i][i];
            }
        }
        return DEFAULT_CELL;
    }

    private char checkDiagonalWin() {

        char firstLeftTopCell = tableTicTacToe[0][0];
        char firstRightTopCell = tableTicTacToe[0][2];
        if (firstLeftTopCell == tableTicTacToe[1][1] && firstLeftTopCell == tableTicTacToe[2][2] || 
            firstRightTopCell == tableTicTacToe[1][1] && firstRightTopCell == tableTicTacToe[2][0]) {
            return tableTicTacToe[1][1];
        }

        return DEFAULT_CELL;
    }
    
}