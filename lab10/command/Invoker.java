package command;

public class Invoker {
    private Command command;

    public Invoker(){
    }

    public void setCommand(Command command){
        this.command = command;
    }

    public boolean executeCommand(){  
        return command.execute();
    }

    public Command getCommand(){
        return command;
    }
}
