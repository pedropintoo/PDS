package Cabazes;

public class Bebida implements Produto{
    private String name;
    private double weight;

    public Bebida(String name, double weight){
        this.name = name;
        this.weight = weight;
    }

    public void draw(){
        Utils.printIdentation();
        System.out.println("Bebida '" + name + "' - Weight : " + weight);
    }

    public double getWeight(){
        return this.weight;
    }
}
