package LeiLao;

public class StockState implements State {

    private Product product;

    public StockState(Product product) {
        this.product = product;
    }

    @Override
    public void pushAuction() {
        product.changeState(new AuctionState(product));
    }

    @Override
    public void Sell() {
        System.out.println("ERROR: Product is not in auction");
    }

}
