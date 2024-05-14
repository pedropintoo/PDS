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