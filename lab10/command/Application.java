/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-05-17
 */

package command;

import java.util.ArrayList;

public class Application {
    private ArrayList<Integer> collection;
    private CommandHistory history;

    public Application() {
        collection = new ArrayList<>();
        history = new CommandHistory();
    }

    public void executeCommand(Invoker invoker){
        if (invoker.executeCommand()){
            history.push(invoker.getCommand());
        }
    }

    public void undoCommand(){
        Command command = history.pop();
        if (command != null){
            command.undo();
        }
    }

    public ArrayList<Integer> getCollection(){
        return collection;
    }
}
