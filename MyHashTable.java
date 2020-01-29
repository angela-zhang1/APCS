import java.util.*;

public class MyHashTable {
	private LinkedList<KeyedItem>[] data;
	public MyHashTable(int sz) {

	}
	public void add(KeyedItem it) {

	}
	public KeyedItem retrieve(Object key) {

	}
	public boolean contains(Object key) {

	}
	private int hash(Object k) { //gives index

	}
	public void resize() {

	}
	public String toString() {
		String ans = "";
		for (int i = 0; i < data.length; i++) {
			ans+= i + " : ";
			for(Object dude:data[i])
				ans+=dude+ " ";
			ans+="\n";
		}
		return ans;
	}
}
