package PagaLeva.Container;

import PagaLeva.Food.Portion;

public abstract class Container {
    private Portion portion;
    
    public Container(Portion portion) {
        this.portion = portion;
    }
    
    public Portion getPortion() {
        return portion;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " with portion = " + portion.toString();
    }
}
