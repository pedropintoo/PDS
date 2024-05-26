package LeiLao;

public class StockState implements State {

    private Product product;

    public StockState(Product product) {
        this.product = product;
    }

    @Override
    public boolean pushAuction() {
        product.changeState(new AuctionState(product));
        return true;
    }

    @Override
    public boolean Sell() {
        System.out.println("ERROR: Product is not in auction");
        return false;
    }

}
