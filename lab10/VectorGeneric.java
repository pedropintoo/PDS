package iterator;
import java.util.Iterator;
import java.util.ListIterator;

public class VectorGeneric<T> implements Iterable<T>, ListIterator {
	private T[] vec;		
	private int nElem;	      
	private final static int ALLOC = 50;   
	private int dimVec = ALLOC;     

	@SuppressWarnings("unchecked")
	public VectorGeneric() {
		vec = (T[]) new Object[dimVec];
		nElem = 0;
	}
	
	public boolean addElem(T elem) {
		if (elem == null)
			return false;
		ensureSpace();
		vec[nElem++] = elem;
		return true;
	}

	private void ensureSpace() {
		if (nElem>=dimVec) {
			dimVec += ALLOC;
			@SuppressWarnings("unchecked")
			T[] newArray = (T[]) new Object[dimVec];
			System.arraycopy(vec, 0, newArray, 0, nElem );
			vec = newArray;
		}
	}

	public boolean removeElem(T elem) {
		for (int i = 0; i < nElem; i++) {
			if (vec[i].equals(elem)) {
				if (nElem-i-1 > 0) // not last element
					System.arraycopy(vec, i+1, vec, i, nElem-i-1 );
				vec[--nElem] = null; // libertar último objecto para o GC
				return true;
			}
		}
		return false;
	}

	public int totalElem() {
		return nElem;
	}
	
	public T getElem(int i) {
		return (T) vec[i];
	}

	@Override
	public java.util.Iterator<T> iterator() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'iterator'");
	}

	@Override
	public void add(Object arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'add'");
	}

	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'hasPrevious'");
	}

	@Override
	public int nextIndex() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'nextIndex'");
	}

	@Override
	public Object previous() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'previous'");
	}

	@Override
	public int previousIndex() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'previousIndex'");
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'remove'");
	}

	@Override
	public void set(Object arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'set'");
	}



}
