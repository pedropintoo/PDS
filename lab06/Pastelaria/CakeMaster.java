package Pastelaria;

// Director
public class CakeMaster {
    private CakeBuilder cakebuilder;

    public CakeMaster(){}
    
    public void setCakeBuilder(CakeBuilder cakebuilder){
        this.cakebuilder = cakebuilder;
    }

    public void createCake(String message){
        createCake(Shape.Circle, 1, message);
    }
    
    public void createCake(int numCakeLayers, String message){
        createCake(Shape.Circle, numCakeLayers, message);
    }

    public void createCake(Shape shape, int numCakeLayers, String message){
        cakebuilder.createCake();
        
        cakebuilder.setCakeShape(shape);
        for (int i = 0; i < numCakeLayers; i++){
            cakebuilder.addCakeLayer();
        }
        cakebuilder.addMessage(message);

        cakebuilder.addCreamLayer();
        cakebuilder.addTopLayer();
        cakebuilder.addTopping();
    }

    public Cake getCake(){
        return cakebuilder.getCake();
    }
}