/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-05-06
 */

package ex2;

import java.util.List;

public class SharkCompany2 {
    public static void main(String[] args) {
        Person[] persons = { new Person("Maria Silva"),
        new Person("Manuel Pereira"),
        new Person("Aurora Machado"),
        new Person("Augusto Lima") };
        FacadeAdmitEmployee shark = new FacadeAdmitEmployee();
        Company.user = User.COMPANY;
        shark.admitEmployee(persons[0], 1000);
        shark.admitEmployee(persons[1], 900);
        shark.admitEmployee(persons[2], 1200);
        shark.admitEmployee(persons[3], 1100);
        List<Employee> sharkEmps = shark.employees();
        for (Employee e : sharkEmps)
            System.out.println(e.getSalary());
            shark.paySalaries(1);
        }
    }