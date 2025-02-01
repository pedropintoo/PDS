/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-03-18
 */

package PagaLeva.Container;

import PagaLeva.Food.Portion;

public class ContainerFactory {
    public static Container create(Portion portion){
        Container container = null;
        switch (portion.getState().name() + portion.getTemperature().name()) {
            case "LiquidCOLD":
                container =  new PlasticBottle(portion);
                break;
            case "LiquidWARM":
                container =  new TermicBottle(portion);
                break;
            case "SolidCOLD":
                container =  new PlasticBag(portion);
                break;
            case "SolidWARM":
                container =  new Tupperware(portion);
                break;
        }
        return container;
    }
}
