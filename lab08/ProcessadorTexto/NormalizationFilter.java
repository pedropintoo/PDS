package ProcessadorTexto;

import java.text.Normalizer;

public class NormalizationFilter extends TextFilterDecorator {
    
    NormalizationFilter(Filter wrappee) {
        super(wrappee);
    }

    @Override
    public String next() {
        return Normalizer
				.normalize(super.next(), Normalizer.Form.NFD)
				.replaceAll("[^\\p{ASCII}]", "");
    }
}