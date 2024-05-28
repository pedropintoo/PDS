package ex1;

import java.util.ArrayList;
import java.util.List;

public class Storage<T> {
    private List<T> phones;

    public Storage() {
        this.phones = new ArrayList<>();
    }

    public void addObject(T phone) {
        this.phones.add(phone);
    }

    public List<T> getPhones() {
        return phones;
    }

}
