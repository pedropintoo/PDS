package ex1;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<Phone> phones;

    public Storage() {
        this.phones = new ArrayList<>();
    }

    public void addObject(Phone phone) {
        this.phones.add(phone);
    }

    public List<Phone> getPhones() {
        return phones;
    }

}
