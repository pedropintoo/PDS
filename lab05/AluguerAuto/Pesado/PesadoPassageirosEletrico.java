/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-03-18
 */

package AluguerAuto.Pesado;

import AluguerAuto.Interfaces.VeiculoEletrico;

public class PesadoPassageirosEletrico extends PesadoPassageiros implements VeiculoEletrico {
    private int autonomia;

    public PesadoPassageirosEletrico(String matricula, String marca, String modelo, int potencia, int numeroQuadro, double peso, int numeroMaxPassageiros, int autonomia) {
        super(matricula, marca, modelo, potencia, numeroQuadro, peso, numeroMaxPassageiros);
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
