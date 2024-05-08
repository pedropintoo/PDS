/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-22
 */

package ProcessadorTexto;

import java.util.ArrayList;
import java.util.List;

public class TermFilter extends TextFilterDecorator {

    List<String> text;

    TermFilter(Filter wrappee) {
        super(wrappee);
        this.text = new ArrayList<>(List.of(super.next().split("[ \t]")));
    }

    @Override
    public boolean hasNext(){
        if (text.size() > 0) {
            return true;
        }

        if (super.hasNext()){
            text.addAll(List.of(super.next().split("[ \t]")));
        }

        return text.size() > 0;
    }

    @Override
    public String next() {
        return text.remove(0);
    }
}