package PagaLeva.Food;

import PagaLeva.State;
import PagaLeva.Temperature;

public class FruitJuice extends Food {

    private final String fruitName = "Orange";

    public FruitJuice(Temperature temp, State state){
        super(temp, state);
    }

    public String getFruitName() {
        return fruitName;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + fruitName + ", Temperature " + super.getTemperature() + ", State " + super.getState();
    }
}