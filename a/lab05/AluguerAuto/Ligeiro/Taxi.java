/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-03-18
 */

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
