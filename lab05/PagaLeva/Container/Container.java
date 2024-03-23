/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-03-18
 */

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
