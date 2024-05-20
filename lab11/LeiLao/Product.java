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

    public Product(String description, double basePrice){
        this.Id = Product.counterID++;
        this.description = description;
        this.basePrice = basePrice;
        subscribers = new ArrayList<Observer>();
        state = new StockState(this);
    }

    public void changeState(State state){
        this.state = state;
    }

    public int getId(){
        return this.Id;
    }

    public void pushAuction(){
        state.pushAuction();
    }
    public void Sell(){
        state.Sell();
    }


    
}
