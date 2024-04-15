package EmpresaPST;

import EmpresaPST.Petiscos.Empregado;
import EmpresaPST.Sweets.Employee;

public class EmployeeAdapter extends Employee{
    private Empregado empregado;

    public EmployeeAdapter(Empregado empregado) {
        super(empregado.nome() + " " +  empregado.apelido(), empregado.codigo(), empregado.salario());
        this.empregado = empregado;
    }

    public String getName() {
        return this.getName();
    }

    public long getEmpNum() {
        long empNum = empregado.codigo();
        return empNum;
    }

    public double getSalary() {
        return empregado.salario();
    }
}
