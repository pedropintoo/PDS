/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-03-18
 */

package PagaLeva.Food;

import PagaLeva.State;
import PagaLeva.Temperature;

public interface Portion { 
    public Temperature getTemperature(); 
    public State getState(); 
} 
   