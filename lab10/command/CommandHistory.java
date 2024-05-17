/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-05-17
 */

package command;
import java.util.Stack;

public class CommandHistory{
    public Stack<Command> history;

    public CommandHistory() {
        history = new Stack<>();
    }

    public void push(Command command){
        history.push(command);
    }

    public Command pop(){
        return history.pop();
    }
}