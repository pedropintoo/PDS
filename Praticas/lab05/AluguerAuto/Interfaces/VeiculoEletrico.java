/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-03-18
 */

package AluguerAuto.Interfaces;

public interface VeiculoEletrico {
    int autonomia(); // devolve autonomia restante
    void carregar(int percentagem); // simula um carregamento até ‘percentagem’
}
