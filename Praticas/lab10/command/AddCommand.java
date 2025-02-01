/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-05-17
 */

package command;
import java.util.ArrayList;

public class AddCommand extends Command{
    public AddCommand(ArrayList<Integer> collection, int element){
        super(collection, element);
    }

    public boolean execute(){
        try {
            collection.add(element);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void undo(){
        try {
            collection.remove(collection.indexOf(element));
        } catch (Exception e) {
            System.out.println("Element not found");
        }
    }
}