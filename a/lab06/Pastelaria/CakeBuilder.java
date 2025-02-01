/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-08
 */

package Pastelaria;

interface CakeBuilder { 
    public void setCakeShape(Shape shape); 
    public void addCakeLayer(); 
    public void addCreamLayer(); 
    public void addTopLayer(); 
    public void addTopping(); 
    public void addMessage(String m); 
    public void createCake(); 
    public Cake getCake(); 
}