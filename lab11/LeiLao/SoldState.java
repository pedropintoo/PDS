package LeiLao;

public class SoldState implements State{
    
    public SoldState(Product product) {
    }

    public void pushAuction() {
        System.out.println("ERROR: Product is already in auction");
    }

    public void Sell() {
        System.out.println("ERROR: Product is already sold");
    }
    
}
