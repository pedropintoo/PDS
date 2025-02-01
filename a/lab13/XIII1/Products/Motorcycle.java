package Products;
public class Motorcycle implements Product {
    private String code;
    private String descr;
    private double points;

    public Motorcycle(String code, String descr, double points) {
        this.code = code;
        this.descr = descr;
        this.points = points;
    }

    @Override
    public String toString() {
        return "Motorcycle [code=" + code + ", descr=" + descr + ", points=" + points +"]";
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String description() {
        return this.descr;
    }

    @Override
    public double points() {
        return this.points;
    }
    
}
