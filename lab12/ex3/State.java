/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-22
 */
package ex3;

public interface State {
    public void registerBook();
    public void requireBook();
    public void returnBook();
    public void reserveBook();
    public void cancelBook();
}
