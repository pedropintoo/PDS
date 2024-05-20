package LeiLao;

public class AuctionState implements State{

    private Product product;

    public AuctionState(Product product) {
        this.product = product;
    }

    @Override
    public void pushAuction() {
        System.out.println("ERROR: Product is already in auction");
    }

    @Override
    public void Sell() {
        product.changeState(new SoldState(product));
    }
    
    
}
