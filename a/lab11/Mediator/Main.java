/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-22
 */
package Mediator;

public class Main {
    public static void main(String args[]) {
        ControlTower controlTower = new ControlTower();
        Plane plane1 = new Plane(controlTower, "F-16");
        Plane plane2 = new Plane(controlTower,"F-22");
        Plane plane3 = new Plane(controlTower,"F-35");

        controlTower.addPlane(plane1);
        controlTower.addPlane(plane2);
        controlTower.addPlane(plane3);
        
        plane1.landing();

        System.out.println();
        plane2.landing();

        System.out.println();
        plane3.landing();
    }
}
