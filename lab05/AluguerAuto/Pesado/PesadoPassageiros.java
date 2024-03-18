package AluguerAuto.Pesado;


public class PesadoPassageiros extends Pesado {
    private final int numeroMaxPassageiros;

    public PesadoPassageiros(String matricula, String marca, String modelo, int potencia, int numeroQuadro, double peso, int numeroMaxPassageiros) {
        super(matricula, marca, modelo, potencia, numeroQuadro, peso);
        this.numeroMaxPassageiros = numeroMaxPassageiros;
    }

    @Override
    public String toString() {
        return super.toString() + ", numeroMaxPassageiros=" + numeroMaxPassageiros;
    }
}

