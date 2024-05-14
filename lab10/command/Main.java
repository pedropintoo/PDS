package command;

public class Main {
    public static void main(String[] args) {
        Application app = new Application();

        Invoker addButton1 = new Invoker();
        addButton1.setCommand(new AddCommand(app.getCollection(), 5));
        
        Invoker addButton2 = new Invoker();
        addButton2.setCommand(new AddCommand(app.getCollection(), 10));

        Invoker removeButton = new Invoker();
        removeButton.setCommand(new RemoveCommand(app.getCollection(), 5));

        app.executeCommand(addButton1);         // Add element 5 -> [5]
        app.executeCommand(addButton2);         // Add element 10 -> [5, 10]
        app.executeCommand(removeButton);       // Remove element 5 -> [10]
        app.undoCommand();                      // Undo remove(5) -> [5, 10]
        app.undoCommand();                      // Undo add(10) -> [5]
        
        System.out.println(app.getCollection()); // [5]
    }
}
