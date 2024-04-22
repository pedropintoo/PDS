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
