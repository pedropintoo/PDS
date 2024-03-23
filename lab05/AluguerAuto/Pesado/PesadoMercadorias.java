/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-03-18
 */

package AluguerAuto.Pesado;

public class PesadoMercadorias extends Pesado {
    private final int cargaMax;

    public PesadoMercadorias(String matricula, String marca, String modelo, int potencia, int numeroQuadro, double peso, int cargaMax) {
        super(matricula, marca, modelo, potencia, numeroQuadro, peso);
        this.cargaMax = cargaMax;
    }

    @Override
    public String toString() {
        return super.toString() + ", cargaMax=" + cargaMax;
    }
}
