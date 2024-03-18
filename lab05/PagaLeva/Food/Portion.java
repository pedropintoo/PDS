package PagaLeva.Food;

import PagaLeva.State;
import PagaLeva.Temperature;

public interface Portion { 
    public Temperature getTemperature(); 
    public State getState(); 
} 
   