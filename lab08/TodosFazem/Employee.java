package TodosFazem;

import java.sql.Date;

public class Employee implements EmployeeInterface{
    public Employee() {
    }

    public void start(Date date) {
        System.out.println("Employee started on " + date);
    }

    public void terminate(Date date) {
        System.out.println("Employee terminated on " + date);
    }

    public void work() {
        System.out.println("Employee is working");
    }
}
