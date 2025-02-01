/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-05-17
 */

package command;
import java.util.ArrayList;

public abstract class Command {
    protected ArrayList<Integer> collection;
    protected int element;

    public Command(ArrayList<Integer> collection, int element){
        this.collection = collection;
        this.element = element;
    }

    public abstract boolean execute();
    public abstract void undo();
}