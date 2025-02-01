/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-22
 */
package LeiLao;

public class SoldState implements State{
    private Product product;
    
    public SoldState(Product product) {
        this.product = product;
    }

    public boolean pushAuction() {
        System.out.println("ERROR: Product is already sold");
        return false;
    }

    public boolean Sell() {
        System.out.println("ERROR: Product is already sold");
        return false;
    }
}
