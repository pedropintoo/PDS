package AluguerAuto.Ligeiro;

import AluguerAuto.VeiculosMotorizados;

public class AutomovelLigueiro extends VeiculosMotorizados {
    private final int numeroQuadro;
    private final int capacidadeBagageira;

    public AutomovelLigueiro(String matricula, String marca, String modelo, int potencia, int numeroQuadro, int capacidadeBagageira) {
        super(matricula, marca, modelo, potencia);
        this.numeroQuadro = numeroQuadro;
        this.capacidadeBagageira = capacidadeBagageira;
    }

    @Override
    public String toString() {
        return super.toString() + ", numeroQuadro=" + numeroQuadro +
                ", capacidadeBagageira=" + capacidadeBagageira;
    }
}
