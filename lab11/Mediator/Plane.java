/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-22
 */
package Mediator;

public class Plane {
    private ControlTower controlTower;
    private String nome;

    public Plane(ControlTower controlTower, String nome){
        this.controlTower = controlTower;
        this.nome = nome;
    }

    @Override
    public String toString(){
        return this.nome;
    }

    public void landing(){
        controlTower.notify(this);
    }

    public void alert(String message){
        System.out.println(message);
    }
}