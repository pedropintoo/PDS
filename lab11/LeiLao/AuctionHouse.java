package LeiLao;
import java.util.List;
import java.util.ArrayList;

public class AuctionHouse {
    private List<Product> products;

    public AuctionHouse(){
        this.products = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void pushAuction(int id, int time) {
        Product product = null;
        for (Product p : products) {
            if (p.getId() == id) {
                product = p;
                break;
            }
        }
        if (product == null) System.out.println("ERROR: Product not found");

        final Product final_Product = product;
        new Thread(new Runnable() {
            public void run() {
                try {
                    final_Product.pushAuction();
                    Thread.sleep(time * 1000);
                    final_Product.Sell();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
