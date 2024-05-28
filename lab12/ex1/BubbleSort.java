package ex1;

import java.util.Comparator;
import java.util.List;

public class BubbleSort<T> extends Algorithm<T> {

    public BubbleSort(SortingFilter sf, List<T> list) {
        super(sf, list);
    }

    public static <T> void bubleSort(List<T> list, Comparator<T> comparator){
        int n = list.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (comparator.compare(list.get(j), list.get(j + 1)) > 0) {
                    // Swap list[j] and list[j + 1]
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (!swapped) break;
        }
    }

    @Override 
    public void concreteSort(){
        switch (super.getSortingFilter()){  
            case MEMORY -> bubleSort(super.getList(), Comparator.comparingInt(Phone::getMemory));
            case PRICE -> bubleSort(super.getList(), Comparator.comparingDouble(Phone::getPrice));
            case CAMERA -> bubleSort(super.getList(), Comparator.comparingInt(Phone::getCamera));
            case PROCESSOR -> bubleSort(super.getList(), Comparator.comparingInt(Phone::getProcessor));
        }
    }
}
