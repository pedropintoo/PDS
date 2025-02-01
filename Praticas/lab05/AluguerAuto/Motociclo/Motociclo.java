/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-03-18
 */

package AluguerAuto.Motociclo;

import AluguerAuto.VeiculosMotorizados;

public class Motociclo extends VeiculosMotorizados {
    private final TipoMotociclo tipo;

    public Motociclo(String matricula, String marca, String modelo, int potencia, TipoMotociclo tipo) {
        super(matricula, marca, modelo, potencia);
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() + ", tipo=" + tipo;
    }
}
