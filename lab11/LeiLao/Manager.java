package LeiLao;

import java.util.List;

public class Manager implements Observer {
    private String name;
    private AuctionHouse auctionHouse;

    public Manager(String name, AuctionHouse auctionHouse){
        this.name = name;
        this.auctionHouse = auctionHouse;
    }

    @Override
    public void notify(String message) {
        System.out.println("Manager " + this.name + " receives: " + message);
    }

    public String getName(){
        return name;
    }

    public List<Product> getStockProducts(){
        return auctionHouse.getStockProducts();
    }

    public List<Product> getAuctionProducts(){
        return auctionHouse.getAuctionProducts();
    }

    public List<Product> getSoldProducts(){
        return auctionHouse.getSoldProducts();
    }
}
