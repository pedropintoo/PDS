public class PassengerShip implements Ship {
    private String code;
    private String name;
    private int maxPassengers;

    public PassengerShip(String code, String name, int maxPassengers) {
        this.code = code;
        this.name = name;
        this.maxPassengers = maxPassengers;
    }

    @Override
    public String toString() {
        return "PassengerShip [code="+code+", name="+name+", passenger="+maxPassengers+"]";
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String name() {
        return this.name;
    }

    public int passengers() {
        return this.maxPassengers;
    }

}