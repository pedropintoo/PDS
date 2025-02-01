package ProcessadorTexto;

public class NormalizationFilter extends TextFilterDecorator {
    
    NormalizationFilter(Filter wrappee) {
        super(wrappee);
    }

    @Override
    public String next() {
        return super.next().replaceAll("[^\\sa-zA-Z0-9]", "");
    }
}