package TodosFazem;

import java.sql.Date;

public class EmployeeDecorator implements EmployeeInterface{
    public EmployeeInterface wrappee;

    public EmployeeDecorator(EmployeeInterface wrappee) {
        this.wrappee = wrappee;
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
    }
}
