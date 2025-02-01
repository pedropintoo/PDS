/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-19
 */

package EmpresaPST;

import EmpresaPST.Petiscos.*;
import EmpresaPST.Sweets.*;

public class Company {
    private Database database;
    private Registos registos;

    public Company(){
        this.database = new Database();
        this.registos = new Registos();
    }

    public Company(Database database, Registos registos){
        this.database = database;
        this.registos = registos;
    }

    public void addEmployee(Employee emp) {
        database.addEmployee(emp);
    }

    public void addEmployee(Empregado emp) {
        // Add employee to the company
        Employee employee = new EmployeeAdapter(emp);
        database.addEmployee(employee);
    }

    public void removeEmployee(long emp_num) {
        // Remove employee from the company
        database.deleteEmployee(emp_num);

    }

    public boolean isEmployee(long empNum){
        for (Employee employee : database.getAllEmployees()) {
            if (employee.getEmpNum() == empNum){
                return true;
            }
        }
        int codigo = (int) empNum;
        return registos.isEmpregado(codigo);
    }

    public Employee[] getAllEmployees(){
        Employee[] employees = new Employee[database.getAllEmployees().length + registos.listaDeEmpregados().size()];
        for (int i = 0; i < database.getAllEmployees().length; i++){
            employees[i] = database.getAllEmployees()[i];
        }
        for (int i = 0; i < registos.listaDeEmpregados().size(); i++){
            Empregado empregado = registos.listaDeEmpregados().get(i);
            Employee employee = new EmployeeAdapter(empregado);
            employees[i + database.getAllEmployees().length] = employee;
        }
        return employees;
    }

}
