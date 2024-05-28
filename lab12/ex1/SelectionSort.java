package ex1;

import java.util.Comparator;
import java.util.List;

public class SelectionSort<T> extends Algorithm<T> {

    public SelectionSort(List<T> list, Comparator<T> comparator) {
        super(list, comparator);
    }

    // Custom sorting method using selection sort algorithm
    public static <T> void selectionSort(List<T> list, Comparator<T> comparator) {
        for (int i = 0; i < list.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (comparator.compare(list.get(j), list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                T temp = list.get(i);
                list.set(i, list.get(minIndex));
                list.set(minIndex, temp);
            }
        }
    }

    @Override 
    public void concreteSort() {
        selectionSort(super.getList(), super.getComparator());
    }
}