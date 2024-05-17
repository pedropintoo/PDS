/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-05-13
 */

package chain_of_responsibility;

public interface ChefInterface {
    public void setNext(ChefInterface chefe);
    public void execute(Food food);
}
