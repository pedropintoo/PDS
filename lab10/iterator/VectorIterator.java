package iterator;

import java.util.ListIterator;

public class VectorIterator<T> implements ListIterator<T>  {
    private VectorGeneric<T> vector;
    private int index;

    public VectorIterator(VectorGeneric<T> vector) {
        this.vector = vector;
        this.index = 0;
    }

    public VectorIterator(VectorGeneric<T> vector, int index) {
        this.vector = vector;
        this.index = index;
    }

    public boolean hasNext() {
        return index < vector.totalElem();
    }

    
    public T next() {
        return vector.getElem(index++);
    }

    public void add(Object arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    
    public boolean hasPrevious() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasPrevious'");
    }

    
    public int nextIndex() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nextIndex'");
    }

    
    public T previous() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'previous'");
    }

    
    public int previousIndex() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'previousIndex'");
    }

    
    public void remove() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    
    public void set(Object arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    

}
