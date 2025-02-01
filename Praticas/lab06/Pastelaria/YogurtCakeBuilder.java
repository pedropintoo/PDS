/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-08
 */

package Pastelaria;

public class YogurtCakeBuilder implements CakeBuilder {
    private Cake cake;

    @Override
    public void createCake() {
        cake = new Cake("Yogurt");
    }

    @Override
    public void setCakeShape(Shape shape) {
        cake.setShape(shape);
    }

    @Override
    public void addCakeLayer() {
        cake.addCakeLayer();
    }

    @Override
    public void addCreamLayer() {
        cake.setMidLayerCream(Cream.Vanilla);
    }

    @Override
    public void addTopLayer() {
        cake.setTopLayerCream(Cream.Red_Berries);
    }

    @Override
    public void addTopping() {
        cake.setTopping(Topping.Chocolate);
    }

    @Override
    public void addMessage(String m) {
        cake.setMessage(m);    
    }

    @Override
    public Cake getCake() {
        return cake;
    }


}