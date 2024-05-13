package iterator;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        VectorGeneric<String> vector = new VectorGeneric<String>();
        vector.addElem("one");
        vector.addElem("two");
        vector.addElem("three");
        vector.addElem("four");
        vector.addElem("five");

        Iterator<String> it = vector.Iterator();
        int i = 0;
        while(i < 2) {
            System.out.println(it.next());
            i++;
        }

        System.out.println();
        Iterator<String> it2 = vector.listIterator();
        while(it2.hasNext()) {
            System.out.println(it2.next());
        }

        System.out.println();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        Iterator<String> it3 = vector.listIterator(3);
        while(it3.hasNext()) {
            System.out.println(it3.next());
        }

    }
}
