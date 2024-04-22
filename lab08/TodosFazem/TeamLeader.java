package TodosFazem;

import java.sql.Date;

public class TeamLeader extends EmployeeDecorator{
    public TeamLeader(EmployeeInterface wrappee) {
        super(wrappee);
    }

    public void plan() {
        System.out.println("TeamLeader plans");
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
        plan();
    }
}
