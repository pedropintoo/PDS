/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-05-06
 */

package ex1;
class Employee extends Person {

private double salary;
	
	public Employee(String n, double s) {
		super(n);
		salary = s;
	}

	public double getSalary() {
		return salary;
	}
}