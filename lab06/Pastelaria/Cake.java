package Pastelaria;

public class Cake {
    private Shape shape; 
    private String cakeLayer; 
    private int numCakeLayers; 
    private Cream midLayerCream; 
    private Cream topLayerCream; 
    private Topping topping; 
    private String message;
    
    public Cake(String cakeLayer){
        this.cakeLayer = cakeLayer;
    }

    public void addCakeLayer() {
        this.numCakeLayers++;
    }

    // Setters

    @Override
    public String toString() {
        return cakeLayer + " cake with " + numCakeLayers + " layers" + 
        (midLayerCream != null ? " and " + midLayerCream + " cream" : "") + 
        ", topped with " + topLayerCream + " cream and " + topping + ". " +
        (message != null ? "Message says: \"" + message + "\"." : "");
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public void setCakeLayer(String cakeLayer) {
        this.cakeLayer = cakeLayer;
    }

    public void setNumCakeLayers(int numCakeLayers) {
        this.numCakeLayers = numCakeLayers;
    }

    public void setMidLayerCream(Cream midLayerCream) {
        this.midLayerCream = midLayerCream;
    }

    public void setTopLayerCream(Cream topLayerCream) {
        this.topLayerCream = topLayerCream;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}