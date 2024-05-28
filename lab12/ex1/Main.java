package ex1;

import java.util.Comparator;

class Main {

    public static void main(String[] args) {
        Storage<Phone> st = new Storage<>();

        Phone p1 = new Phone(600.99, new Processor(5) , new Camera(0), new Memory(16) );
        Phone p2 = new Phone(200.99, new Processor(15) , new Camera(20), new Memory(8));
        Phone p3 = new Phone(101.50, new Processor(1) , new Camera(10), new Memory(2));
        Phone p4 = new Phone(2.45, new Processor(0) , new Camera(300), new Memory(1));
        Phone p5 = new Phone(1250.99, new Processor(25) , new Camera(200), new Memory(32));

        st.addObject(p1);
        st.addObject(p2);
        st.addObject(p3);
        st.addObject(p4);
        st.addObject(p5);

        Algorithm<Phone> alg1;

        System.out.println();
        alg1 = new InsertionSort<>(st.getPhones(), Comparator.comparingDouble(Phone::getPrice));
        alg1.sort(st.getPhones());

        System.out.println();
        alg1 = new SelectionSort<>(st.getPhones(), Comparator.comparingDouble(Phone::getMemory));
        alg1.sort(st.getPhones());

        System.out.println();
        alg1 = new InsertionSort<>(st.getPhones(), Comparator.comparingDouble(Phone::getProcessor));
        alg1.sort(st.getPhones());

    }
}