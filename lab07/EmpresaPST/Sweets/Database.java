/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-19
 */

package EmpresaPST.Sweets;
import java.util.Vector;

// Sweets
public class Database { // Data elements
    private Vector<Employee> employees; // Stores the employees
    
    public Database() {
        employees = new Vector<>();
    }

    public boolean addEmployee(Employee employee) {
        try {
            employees.add(employee);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void deleteEmployee(long emp_num) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmpNum() == emp_num) {
                employees.remove(i);
                break;
            }
        }
    }

    public Employee[] getAllEmployees() {
        Employee[] employeesArray = new Employee[employees.size()];
        for (int i = 0; i < employees.size(); i++){
            employeesArray[i] = employees.get(i);
        }
        return employeesArray;
    }
}
