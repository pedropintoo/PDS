import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ShipOfSmallShips implements Ship,Iterable<String> {
    private List<PassengerShip> passengerShipsList;
    private String code;
    private String name;

    public ShipOfSmallShips(String code, String name) {
        this.code = code;
        this.name = name;
        this.passengerShipsList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Container Ship with "+this.passengerShipsList.size()+" ships. "
                + "Total passengers capacity: " + this.getTotalCapacity()
                + this.getPassengerShips();
    }

    private String getPassengerShips() {
        StringBuilder sb = new StringBuilder();

        for (String ship : this) {
            sb.append("\t\t");
            sb.append(ship);
        }

        return sb.toString();
    }

    private double getTotalCapacity() {
        return this.passengerShipsList.stream().mapToInt(PassengerShip::passengers).sum();
    }

    public Iterator<String> iterator() {
        return this.passengerShipsList.stream().map((PassengerShip ship) -> {
            return ship.toString();
        }).iterator(); 
    }

    // NOT COMPLETED.....
    public boolean add(Ship p) {
        if (!(p instanceof PassengerShip)) return false;
        PassengerShip passengerShip = (PassengerShip) p;


        return this.passengerShipsList.add(passengerShip); // if null it's not in the list
    }

    public void remove(Ship p) {
        this.passengerShipsList.remove(p);
    }

    public String code() {
        return this.code;
    }

    public String name() {
        return this.name;
    }

}
    