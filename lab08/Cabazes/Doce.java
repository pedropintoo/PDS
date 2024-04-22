package Cabazes;

public class Doce implements Produto{
    private String name;
    private double weight;

    public Doce(String name, double weight){
        this.name = name;
        this.weight = weight;
    }

    public void draw(){
        Utils.printIdentation();
        System.out.println("Doce '" + name + "' - Weight : " + weight);
    }
    
    public double getWeight(){
        return this.weight;
    }
}
