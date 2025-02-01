/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-05-17
 */

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
