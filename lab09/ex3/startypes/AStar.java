/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-05-06
 */

package ex3.startypes;
import java.awt.Color;

public class AStar extends StarType{
    public static StarType instance;
    
    public AStar() {
        super(2, Color.WHITE);
        this.description = "This is a long description of the A type star....";
        // This would store the values of physical properties for each type of star
        this.physicalProperties = new Float[10];
    }

    public static StarType getInstance(){
        if(instance == null){
            instance = new AStar();
        }
        return instance;
    }
}
