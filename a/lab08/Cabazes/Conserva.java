package Cabazes;

public class Conserva implements Produto{
    private String name;
    private double weight;

    public Conserva(String name, double weight){
        this.name = name;
        this.weight = weight;
    }

    public void draw(){
        Utils.printIdentation();
        System.out.println("Conserva '" + name + "' - Weight : " + weight);
    }

    public double getWeight(){
        return this.weight;
    }
}
