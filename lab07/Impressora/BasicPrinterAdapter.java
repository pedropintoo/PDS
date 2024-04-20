/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-19
 */

package Impressora;

public class BasicPrinterAdapter extends AdvancedPrinter {

    private BasicPrinter basicPrinter;

    public BasicPrinterAdapter(BasicPrinter basicPrinter) {
        super();
        this.basicPrinter = basicPrinter;
    }

}
