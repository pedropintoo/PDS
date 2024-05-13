package command;
import java.util.Stack;

public class CommandHistory{
    public Stack<Command> history;

    public CommandHistory() {
    }

    public void push(Command command){
        history.push(command);
    }

    public void pop(){
        history.pop();
    }
}