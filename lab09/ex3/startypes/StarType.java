/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-05-06
 */

package ex3.startypes;
import java.awt.*;

public abstract class StarType {
    private int size;
    private Color color;
    protected String description;
    protected Float[] physicalProperties;

    public StarType(int size, Color color) {
        this.size = size;
        this.color = color;
    }

    public int getSize(){
        return this.size;
    }

    public Color getColor(){
        return this.color;
    }

    public String getDescription(){
        return this.description;
    }

    public Float[] getPhysicalProperties(){
        return this.physicalProperties;
    }
}
