/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-03-18
 */

package PagaLeva.Food;

import PagaLeva.State;
import PagaLeva.Temperature;

public abstract class Food implements Portion{
    private Temperature temp;
    private State state;
    
    public Food(Temperature temp, State state){
        this.temp = temp;
        this.state = state;
    }

    @Override
    public Temperature getTemperature() {
        return temp;
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": Temperature " + temp.name() + ", State " + state.name();
    }

}
