package LeiLao;
import java.util.List;
import java.util.ArrayList;

public class AuctionHouse {
    private List<Product> products;
    private Observer manager;

    public AuctionHouse(){
        this.products = new ArrayList<Product>();
    }

    public void setManager(Observer manager){
        this.manager = manager;
    }

    public void addProduct(Product product) {
        products.add(product);
        product.subscribe(manager);
    }

    public void pushAuction(int id, int time) {
        Product product = null;
        for (Product p : products) {
            if (p.getId() == id) {
                product = p;
                break;
            }
        }
        if (product == null) {
            System.out.println("ERROR: Product not found");
            return;
        }

        product.pushAuction(time);
    }

    public List<Product> getStockProducts(){
        List<Product> stockProducts = new ArrayList<Product>();
        for (Product p : products) {
            if (p.getState() instanceof StockState) {
                stockProducts.add(p);
            }
        }
        return stockProducts;
    }

    public List<Product> getAuctionProducts(){
        List<Product> auctionProducts = new ArrayList<Product>();
        for (Product p : products) {
            if (p.getState() instanceof AuctionState) {
                auctionProducts.add(p);
            }
        }
        return auctionProducts;
    }

    public List<Product> getSoldProducts(){
        List<Product> soldProducts = new ArrayList<Product>();
        for (Product p : products) {
            if (p.getState() instanceof SoldState) {
                soldProducts.add(p);
            }
        }
        return soldProducts;
    }
}
