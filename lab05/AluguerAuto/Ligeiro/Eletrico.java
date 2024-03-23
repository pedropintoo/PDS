/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-03-18
 */

package AluguerAuto.Ligeiro;

import AluguerAuto.Interfaces.VeiculoEletrico;

public class Eletrico extends AutomovelLigueiro implements VeiculoEletrico {
    private int autonomia; // percentagem [0,100]%

    public Eletrico(String matricula, String marca, String modelo, int potencia, int numeroQuadro, int capacidadeBagageira, int autonomia) {
        super(matricula, marca, modelo, potencia, numeroQuadro, capacidadeBagageira);
        this.autonomia = autonomia;
    }

    @Override
    public String toString() {
        return super.toString() + ", autonomia=" + autonomia;
    }

    // TODO: Public methods by interface --> VeiculoEletrico

    @Override
    public int autonomia() {
        return this.autonomia;
    }

    @Override
    public void carregar(int percentagem) {
        this.autonomia = Math.max(percentagem, this.autonomia);
    }
}
