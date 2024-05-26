/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-22
 */
package LeiLao;
import java.util.ArrayList;
import java.util.List;

public class Product {
    private static int counterID = 0;
    private State state;

    private List<Observer> subscribers;
    private String description;
    private double basePrice;
    private int Id;
    private double highestBid;

    public Product(String description, double basePrice){
        this.Id = Product.counterID++;
        this.description = description;
        this.basePrice = basePrice;
        subscribers = new ArrayList<Observer>();
        state = new StockState(this);
        this.highestBid = 0;
    }

    public void changeState(State state){
        this.state = state;
    }

    public int getId(){
        return this.Id;
    }

    public void pushAuction(int time){
        if (state.pushAuction()){
            new Thread(() -> {
                try {
                    Thread.sleep(time * 1000);
                    this.closeAuction();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public void closeAuction(){
        if (getHighestBid() > 0){
            Sell();
        }
        else {
            System.out.println("Product " + this.Id + " has no bids, it will be sent to stock");
            changeState(new StockState(this));
        }
    }

    public boolean Sell(){
        if (state.Sell()){
            notifySubscribers(this.description + " has been sold for " + this.highestBid);
            return true;
        }
        return false;
    }


    public void subscribe(Observer observer){
        subscribers.add(observer);
    }

    public void notifySubscribers(String message){
        for(Observer observer : subscribers){
            observer.notify(message);
        }
    }

    public void bid(Observer client, double bid){
        if(bid > highestBid && state instanceof AuctionState && client instanceof Client && bid > basePrice){
            highestBid = bid;
            notifySubscribers(client.getName() + " has bid " + bid + " on Product:" + this.Id + " Description:" + this.description);
            subscribe(client);
        }
    }  
    
    public State getState(){
        return state;
    }

    public double getHighestBid(){
        return highestBid;
    }
}
