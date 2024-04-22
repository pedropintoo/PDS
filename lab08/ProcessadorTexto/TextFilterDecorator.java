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
