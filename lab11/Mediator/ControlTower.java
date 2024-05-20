package Mediator;

import java.util.ArrayList;
import java.util.List;

public class ControlTower {
    private List<Plane> planes;

    public ControlTower(){
        this.planes = new ArrayList<Plane>();
    }

    public void notify(Plane plane) {
        for (Plane p : planes) {
            if (p.equals(plane)) continue;
            p.alert("ALERT - " + plane + " landing in the next minutes!");
        }
    }

    public void addPlane(Plane plane){
        planes.add(plane);
    }
}
