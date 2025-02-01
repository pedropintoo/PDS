/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-22
 */

package ProcessadorTexto;

public class CapitalizationFilter extends TextFilterDecorator {
    
    CapitalizationFilter(Filter wrappee) {
        super(wrappee);
    }

    @Override
    public String next() {
        String text = super.next();
        
        if (text.length() < 3){
            return text.toUpperCase();
        }

        String firstLetter = String.valueOf(text.charAt(0)).toUpperCase();
        String lastLetter = String.valueOf(text.charAt(text.length()-1)).toUpperCase();

        return firstLetter + text.substring(1, text.length()).toLowerCase() + lastLetter;
    }
}