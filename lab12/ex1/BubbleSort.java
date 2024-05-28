package ex1;

import java.util.Comparator;
import java.util.List;

// Define the BubbleSort class as a generic class with a type parameter T
public class BubbleSort<T> extends Algorithm<T> {

    // Adjust the constructor to accept List<T> and SortingFilter
    public BubbleSort(List<T> list, Comparator<T> comparator) {
        super(list, comparator);
    }

    // The generic bubbleSort method remains the same
    public static <T> void bubbleSort(List<T> list, Comparator<T> comparator) {
        int n = list.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (comparator.compare(list.get(j), list.get(j + 1)) > 0) {
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Override the concreteSort method to use generics properly
    @Override 
    public void concreteSort() {
        bubbleSort(super.getList(), super.getComparator());
    }
}