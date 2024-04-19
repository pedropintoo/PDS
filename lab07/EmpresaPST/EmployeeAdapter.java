/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-19
 */

package EmpresaPST;

import EmpresaPST.Petiscos.Empregado;
import EmpresaPST.Sweets.Employee;

public class EmployeeAdapter extends Employee{
    private Empregado empregado;

    public EmployeeAdapter(Empregado empregado) {
        super(empregado.nome() + " " +  empregado.apelido(), empregado.codigo(), empregado.salario());
        this.empregado = empregado;
    }

    @Override
    public String getName() {
        return this.getName();
    }

    @Override
    public long getEmpNum() {
        long empNum = empregado.codigo();
        return empNum;
    }

    @Override
    public double getSalary() {
        return empregado.salario();
    }
}
