/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-22
 */
package ex1;

public class Phone{
    private double price;
    private Processor processor;
    private Camera camera;
    private Memory memory;

    public Phone(double price, Processor processor, Camera camera, Memory memory){
        this.price = price;
        this.processor = processor;
        this.camera = camera;
        this.memory = memory;
    }

    

    @Override
    public String toString() {
        return "Phone [price=" + price + ", processor=" + processor.getCores() + ", camera=" + camera.getMegaPixels() + ", memory=" + memory.getRam() + "]";
    }

    public double getPrice(){
        return price;
    }

    public int getProcessor(){
        return processor.getCores();
    }

    public int getCamera(){
        return camera.getMegaPixels();
    }

    public int getMemory(){
        return memory.getRam();
    }

    


}