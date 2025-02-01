/**
 * @ Author: Pedro Pinto (pmap@ua.pt) & Guilherme Santos (gui.santos91@ua.pt)
 * @ Create Time: 2024-05-13
 */

package iterator;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        VectorGeneric<String> vector = new VectorGeneric<String>();
        vector.addElem("zero");
        vector.addElem("one");
        vector.addElem("two");
        vector.addElem("three");
        vector.addElem("four");
        

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

        System.out.println();
        Iterator<String> it3 = vector.listIterator(3);
        while(it3.hasNext()) {
            System.out.println(it3.next());
        }

    }
}
