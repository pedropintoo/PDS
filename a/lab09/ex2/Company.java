/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-05-06
 */

package ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Company {

public static User user;
private List<Employee> emps = new ArrayList<>();

	public void admitEmployee(Person person, double salary) {
		Employee e = new Employee(person, salary);
		emps.add(e);
	}

	public void paySalaries(int month) {
		for (Employee e : emps) {
			Person p = e.getPerson();
			p.deposit(e.getSalary());
		}
	}

	public List<Employee> employees() {
		return Collections.unmodifiableList(emps);
	}
}