/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-22
 */
package LeiLao;

public class Client implements Observer{
    private String name;  
    
    public Client(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void bid(Product product, double bid){
        product.bid(this, bid);
    }

    public void notify(String message){
        System.out.println(name + " has been notified: " + message);
    }
}
