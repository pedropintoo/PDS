package ex1;

import java.util.ArrayList;
import java.util.List;

// Template pattern
public abstract class Algorithm<T> {
    
    private SortingFilter sortingFilter;
    private List<T> list;

    public Algorithm(SortingFilter sf, List<T> list) {
        this.sortingFilter = sf;
        this.list = list;
    }

    // to be override
    public abstract void concreteSort(List<T> list);

    public void sort(List<T> list) {
        ArrayList<T> sorted_list = new ArrayList<>(list);
        concreteSort(sorted_list);
        sorted_list.forEach(obj -> System.out.println(obj));
    }

    public SortingFilter getSortingFilter() {
        return this.sortingFilter;
    }

    public List<T> getList() {
        return this.list;
    }

}
