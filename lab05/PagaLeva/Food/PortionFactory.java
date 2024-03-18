package PagaLeva.Food;

import PagaLeva.Temperature;
import PagaLeva.State;

public class PortionFactory {
    public static Portion create(String state, Temperature temp) {
        Portion portion = null;
        switch (state + temp.toString()){
            case "BeverageWARM":
                portion = new Milk(temp, State.Liquid);
                break;
            case "BeverageCOLD":
                portion = new FruitJuice(temp, State.Liquid);
                break;
            case "MeatWARM":
                portion = new Pork(temp, State.Solid);
                break;
            case "MeatCOLD":
                portion = new Tuna(temp, State.Solid);
                break;
        }
        return portion;
    }
}
