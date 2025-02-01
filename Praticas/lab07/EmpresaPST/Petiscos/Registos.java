/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-19
 */

package EmpresaPST.Petiscos;
import java.util.ArrayList;
import java.util.List;

public class Registos {
    // Data elements
    private ArrayList<Empregado> empregados; // Stores the employees

    public Registos() {
        empregados = new ArrayList<>();
    }

    public void insere(Empregado emp) {
        empregados.add(emp);
    }

    public void remove(int codigo) {
        for (Empregado empregado : empregados) {
            if (empregado.codigo() == codigo){
                empregados.remove(empregado);
                break;
            }
        }
    }

    public boolean isEmpregado(int codigo) {
        for (Empregado empregado : empregados) {
            if (empregado.codigo() == codigo){
                return true;
            }
        }
        return false;
    }
    public List<Empregado> listaDeEmpregados() {
        return empregados;
    }
}
