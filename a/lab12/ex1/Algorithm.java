/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-22
 */
package ex1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Template pattern
public abstract class Algorithm<T> {
    
    private Comparator<T> comparator;
    private List<T> list;

    public Algorithm(List<T> list, Comparator<T> comparator) {
        this.comparator = comparator;
        this.list = new ArrayList<>(list); // not change the original list
    }

    // to be override
    public abstract void concreteSort();

    public void sort(List<T> list) {
        concreteSort();
        this.list.forEach(obj -> System.out.println(obj));
    }

    public Comparator<T> getComparator() {
        return this.comparator;
    }

    public List<T> getList() {
        return this.list;
    }

}
