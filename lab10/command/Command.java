package command;
import java.util.ArrayList;

public abstract class Command {
    protected ArrayList<Integer> collection;
    public Command(ArrayList<Integer> collection){
        this.collection = collection;
    }

    public abstract void execute();
    public abstract void undo();
}