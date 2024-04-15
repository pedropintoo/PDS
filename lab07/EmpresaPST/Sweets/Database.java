package EmpresaPST.Sweets;
import java.util.Vector;

// Sweets
public class Database { // Data elements
    private Vector<Employee> employees; // Stores the employees
    
    public Database() {
        employees = new Vector<>();
    }

    public boolean addEmployee(Employee employee) {
        // Code to add employee
        return true;
    }

    public void deleteEmployee(long emp_num) {
        // Code to delete employee
        return;
    }

    public Employee[] getAllEmployees() {
        // Code to retrieve collection
        return null;
    }
}
