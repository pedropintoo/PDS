/**
 * @ Author: Pedro Pinto (pmap@ua.pt)
 * @ Create Time: 2024-03-04
 */

public interface JGaloInterface {
	// X or O
	public abstract char getActualPlayer();
	// Can be played?
	public abstract boolean setJogada(int lin, int col);
	// We have a winner or Draw
	public abstract boolean isFinished();
	public abstract char checkResult();
}