import java.util.*;

public class CellStack {
	private ArrayList<Object> data;
	private int size = 0;
	public CellStack() {
		data = new ArrayList<Object> ();
	}
	public Object peek() {
		return data.get(size-1);
	}
	public void push(Object o) {
		data.add(o);
		size++;
	}
	public Object pop () {
		if (size!=0) {
			size--;
			return data.remove(size);
		}
		return null;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
}
