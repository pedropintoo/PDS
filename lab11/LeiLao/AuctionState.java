package LeiLao;

public class AuctionState implements State{

    private Product product;

    public AuctionState(Product product) {
        this.product = product;
    }

    @Override
    public boolean pushAuction() {
        System.out.println("ERROR: Product is already in auction");
        return false;
    }

    @Override
    public boolean Sell() {
        product.changeState(new SoldState(product));
        return true;
    }
    
}
