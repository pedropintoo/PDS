/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-05-06
 */

package ex3;

import ex3.startypes.*;
import java.awt.*;


public class Star {
    public int x;
    public int y;
    public StarType type;

    public Star(int x, int y, StarType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw(Graphics g) {
        g.setColor(type.getColor());
        g.fillOval(x, y , type.getSize(), type.getSize());
    }
}