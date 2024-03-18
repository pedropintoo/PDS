package AluguerAuto.Ligeiro;

public class Taxi extends AutomovelLigueiro {

    private final int numeroLicenca;

    public Taxi(String matricula, String marca, String modelo, int potencia, int numeroQuadro, int capacidadeBagageira, int numeroLicenca) {
        super(matricula, marca, modelo, potencia, numeroQuadro, capacidadeBagageira);
        this.numeroLicenca = numeroLicenca;
    }

    @Override
    public String toString() {
        return super.toString() + ", numeroLicenca=" + numeroLicenca;
    }
}
