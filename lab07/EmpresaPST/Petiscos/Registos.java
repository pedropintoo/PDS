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
    }

    public boolean isEmpregado(int codigo) {
        // Code to find employee
        return true;
    }
    public List<Empregado> listaDeEmpregados() {
        // Code to retrieve collection
        return null;
    }
}
