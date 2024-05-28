/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-22
 */
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
