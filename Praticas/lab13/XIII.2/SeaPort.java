import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class SeaPort implements Port {

    private Map<String, Ship> shipsList;

    public SeaPort() {
        this.shipsList = new HashMap<>();
    }

    public Iterator<String> iterator() {
        return this.shipsList.entrySet().stream().map((Entry<String, Ship> entry) -> {
            return "Ref: " + entry.getKey() + " - " + entry.getValue();
        }).iterator(); 
    }

    public boolean add(String ref, Ship p) {
        return this.shipsList.put(ref, p) == null; // if null it's not in the list
    }

    public boolean exists(String ref) {
        return this.shipsList.containsKey(ref);
    }

    public Ship remove(String ref) {
        if (!this.exists(ref)) return null;

        System.out.println(this.shipsList.get(ref).name() + " removed");
        return this.shipsList.remove(ref);
    }

}
