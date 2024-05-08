/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-05-06
 */

package ex3.startypes;
import java.awt.Color;

public class GStar extends StarType{
    public static StarType instance;
    
    public GStar() {
        super(1, new Color(245, 250, 250));
        this.description = "This is a long description of the G type star....";
        // This would store the values of physical properties for each type of star
        this.physicalProperties = new Float[10];
    }

    public static StarType getInstance(){
        if(instance == null){
            instance = new GStar();
        }
        return instance;
    }
}
