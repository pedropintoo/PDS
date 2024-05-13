package chain_of_responsibility;

public interface ChefInterface {
    public void setNext(ChefInterface chefe);
    public void execute(Food food);
}
