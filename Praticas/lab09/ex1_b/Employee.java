/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-05-06
 */

package ex1_b;
class Employee {

	private double salary;
	private Person person;
		
	public Employee(Person person, double s) {
		this.person = person;
		this.salary = s;
	}

	public double getSalary() {
		return salary;
	}
	
	public Person getPerson() {
		return this.person;
	}
}