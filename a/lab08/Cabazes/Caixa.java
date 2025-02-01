package Cabazes;

import java.util.ArrayList;
import java.util.List;

public class Caixa implements Produto{
    private String name;
    private double boxWeight;
    private List<Produto> products;

    public Caixa(String name, double boxWeight){
        this.name = name;
        this.boxWeight = boxWeight;
        this.products = new ArrayList<Produto>();
    }

    public void add(Produto produto){

        products.add(produto);
    }

    public void draw(){
        Utils.printIdentation();
        System.out.println("* Caixa '" + name + "' [ Weight: " + boxWeight + "; Total: " + getWeight() + " ]");
        Utils.identationInc++;
        for(Produto produto : products){
            produto.draw();
        }
        Utils.identationInc--;
    }

    public double getWeight(){
        double total = boxWeight;
        for (Produto produto : products){
            total += produto.getWeight();
        }
        return total;
    }
}
