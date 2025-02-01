/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-22
 */

package ProcessadorTexto;

public interface Filter {
    boolean hasNext();
    String next();
}
