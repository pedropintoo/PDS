/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-04-22
 */
package ex1;

import java.util.Comparator;
import java.util.List;

public class InsertionSort<T> extends Algorithm<T>{

    public InsertionSort(List<T> list, Comparator<T> comparator) {
        super(list, comparator);
    }

    public static <T> void insertionSort(List<T> list, Comparator<T> comparator) {
        int n = list.size();
        for (int i = 1; i < n; i++) {
            T key = list.get(i);
            int j = i - 1;

            while (j >= 0 && comparator.compare(list.get(j), key) > 0) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1, key);
        }
    }

    @Override
    public void concreteSort() {
        insertionSort(super.getList(), super.getComparator());
    } 

}

