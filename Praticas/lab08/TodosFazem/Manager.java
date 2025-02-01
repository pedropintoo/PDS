package TodosFazem;

import java.sql.Date;

public class Manager extends EmployeeDecorator{
    public Manager(EmployeeInterface wrappee) {
        super(wrappee);
    }

    public void manage() {
        System.out.println("Manager manages");
    }

    @Override
    public void start(Date date) {
        wrappee.start(date);
    }

    @Override
    public void terminate(Date date) {
        wrappee.terminate(date);
    }

    @Override
    public void work() {
        wrappee.work();
        manage();
    }
}
