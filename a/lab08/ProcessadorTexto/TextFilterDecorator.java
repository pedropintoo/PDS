/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-22
 */

package ProcessadorTexto;

public class TextFilterDecorator implements Filter {

    private Filter wrappee;

    TextFilterDecorator(Filter wrappee) {
        this.wrappee = wrappee;
    }

    public boolean hasNext() {
        return wrappee.hasNext();
    }

    public String next() {
        return wrappee.next();
    }
    
}
