package LeiLao;

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
}
