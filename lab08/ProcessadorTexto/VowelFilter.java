/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-22
 */

package ProcessadorTexto;

public class VowelFilter extends TextFilterDecorator{

    VowelFilter(Filter wrappee) {
        super(wrappee);
    }

    @Override
    public String next() {
        String text = super.next();

        StringBuilder res = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                res.append(c);
            }
        }
        
        return res.toString();
    }
    
}
