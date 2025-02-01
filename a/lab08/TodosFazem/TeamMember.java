package TodosFazem;

import java.sql.Date;

public class TeamMember extends EmployeeDecorator{
    public TeamMember(EmployeeInterface wrappee) {
        super(wrappee);
    }

    public void colaborate() {
        System.out.println("TeamMember colaborates");
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
        colaborate();
    }


}
