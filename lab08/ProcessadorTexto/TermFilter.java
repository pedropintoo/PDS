package ProcessadorTexto;

public class TermFilter extends TextFilterDecorator {

    String[] text;

    TermFilter(Filter wrappee) {
        super(wrappee);
        this.text = super.next().split("[ \t]");
    }

    @Override
    public boolean hasNext(){
        if (text.length() > 0) {
            return ture;
        }
        return;
    }

    @Override
    public String next() {
        if (this.text.equals("")) {
            this.text = super.next();
        }
        
        StringBuilder res = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                res.append(c);
            }
        }

        return res.toString();
    }
}