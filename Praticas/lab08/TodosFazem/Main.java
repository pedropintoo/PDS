package TodosFazem;

import java.sql.Date;

public class Main{
    public static void main(String[] args) {
        EmployeeInterface employee = new Employee();
        EmployeeInterface employeeManager = new Manager(employee);
        EmployeeInterface employeeManagerLeader = new TeamLeader(employeeManager);
        EmployeeInterface employeeManagerLeaderMember = new TeamMember(employeeManagerLeader);
        employeeManagerLeaderMember.start(Date.valueOf("2021-01-01"));
        employeeManagerLeaderMember.work();
        employeeManagerLeaderMember.terminate(Date.valueOf("2021-12-31"));
    }
}
