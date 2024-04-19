/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-19
 */

package EmpresaPST;
import EmpresaPST.Sweets.*;
import EmpresaPST.Petiscos.*;

public class Main {
    public static void main(String[] args) {
        Empregado emp1 = new Empregado("João", "Silva", 1, 1000);
        Empregado emp2 = new Empregado("Maria", "Santos", 2, 1200);
        Empregado emp3 = new Empregado("Manuel", "Fernandes", 3, 1500);
        Registos reg = new Registos();
        reg.insere(emp1);
        reg.insere(emp2);
        reg.insere(emp3);

        Employee emp4 = new Employee("João Silva", 4, 1000);
        Employee emp5 = new Employee("Maria Santos", 5, 1200);
        Employee emp6 = new Employee("Manuel Fernandes", 6, 1500);
        Database db = new Database();
        db.addEmployee(emp4);
        db.addEmployee(emp5);
        db.addEmployee(emp6);

        Company company = new Company(db, reg);
        company.removeEmployee(1);
        company.removeEmployee(4);
        Empregado emp7 = new Empregado("António", "Ferreira", 7, 2000);
        company.addEmployee(emp7);
        Employee[] employees = company.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
