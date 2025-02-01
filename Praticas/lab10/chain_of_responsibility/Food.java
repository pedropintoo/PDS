/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-05-13
 */

package chain_of_responsibility;

public class Food {
    private FoodType type;
    private String name;
    private int time;

    public Food(FoodType type, String name, int time){
        this.name = name;
        this.type = type;
        this.time = time;
    }

    @Override
    public String toString() {
        return name;
    }

    public FoodType getType(){
        return this.type;
    }

    public int getTime(){
        return this.time;
    }

    public String getName(){
        return this.name;
    }
}
