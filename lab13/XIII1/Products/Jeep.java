package Products;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Jeep implements Product {
    private String code;
    private String descr;
    private double points;

    public Jeep(OldJeep oldJeep) {
        String data = oldJeep.getData();
        String[] splitData = data.split(";");

        this.code = splitData[0];
        this.descr = splitData[1];
        this.points = Double.parseDouble(splitData[2]);
    }

    public Jeep(String code, String descr, double points) {
        this.code = code;
        this.descr = descr;
        this.points = points;
    }

    @Override
    public String toString() {
        return "Jeep [code=" + code + ", descr=" + descr + ", points=" + points +"]";
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
