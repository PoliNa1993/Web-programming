import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

class Value {
	Object val;
	Integer key;
	
	Value(Integer key, Object val) {
		this.key = key;
		this.val= val;
	}
	
	Value() {}
}


public class CREA2 {
	
	private final static int[] primes = {
			37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997
	};
	
	
	private LinkedList<Value> values = new LinkedList<Value>();
	
	private int currentPrime = 0;

	private Value data [];
	
	private int size;
	
	private int capacity;
	
	private double ratio = 0.5;
	
	private int threshold = 30;
	
	boolean useLinkedList = true;
	
	
	CREA2() {
		this.size = 0;
		this.capacity = primes[currentPrime];
		this.data = new Value[primes[currentPrime]];
		
	}
	
	private void move() {
		size = 0;
		for (Value val : values) {
			add(val.key, val.val);
		}
		
	}
	
	private void resize() {
		double ratio = (double)size / (double)capacity;
		
		
		if (ratio < this.ratio) {
			return;
		}
		
	
		
		Value temp[] = new Value[capacity];
		for (int i = 0; i < capacity; i++) {
			temp[i] = data[i];
		}
		
		data = new Value[primes[++currentPrime]];
		
		capacity = primes[currentPrime];
		size = 0;
		for (Value val : temp) {
			if (val == null) continue;
			add(val.key, val.val);
		}
	}
	
	public void add(Integer key, Object value) {
		if (size < threshold && useLinkedList) {
			values.add(new Value(key, value));
			size++;
			return;
		} else if (useLinkedList){
			useLinkedList = false;
			move();
		}
		
		resize();
		
		Value v = new Value();
		v.key = key;
		v.val = value;
		
		int hash = generate(key);
		
		if (data[hash] != null) {
			hash = linearProbe(key);
			data[hash] = v;
		} else {
			data[hash] = v;
		}
		
		size++;
	}
	
	public Object remove(Integer key) {
		
		if (useLinkedList) {
			for (int i = 0 ; i < values.size(); i++) {
				Value val = values.get(i);
				if (val.key.equals(key)) {
					values.remove(i);
					return val.val;
				}
			}
 		}

		int hash = generate(key);
		
		if (data[hash] != null && data[hash].key.equals(key))
		{
			size--;
			Value t = data[hash];
			data[hash] = null;
			return t.val;
		}
		else for(int i = 0; i < capacity; i++) {
			if (data[i] != null && data[i].key.equals(key)) {
				size--;
				Value t = data[i];
				data[i] = null;
				return t.val;
			}
		}
		
		
		return null;
	}
	
	public int linearProbe(Integer key) {
		for (int i = 0; i < capacity; i++) {
			if (data[i] != null)
				return i;
		}
		
		return -1;
	}
	
	private int generate(Integer key) {
		return key % capacity;
	}
	
	public ArrayList<Integer> allKeys() {
		ArrayList<Integer> res = new ArrayList<>();
		
		if(useLinkedList) {
			for (Value val : values) {
				res.add(val.key);
			}
			
			return res;
		}
		
		
		for (Value val : data) {
			if (val != null) {
				res.add(new Integer(val.key));
			}
		}
		
		return res;
	}
	
	public ArrayList<Object> getValues() {
		ArrayList<Object> res = new ArrayList<>();
		
		if (useLinkedList) {
			for (Value val : values) {
				res.add(val.val);
			}
			
			return res;
		}
		
		for (Value val : data) {
			if (val != null) {
				res.add(val.val);
			}
 		}
		
		return res;
	}
	
	public Integer nextKey(Integer key) {
		ArrayList<Integer> keys = allKeys();
		boolean next = false;
		for (Integer k : keys) {
			if (k.equals(key)) next = true;
			else if (next)
				return k;
		}
		
		return null;
	}
	
	public Integer prevKey(Integer key) {
		ArrayList<Integer> keys = allKeys();
		boolean next = false;
		
		for (int i = keys.size() - 1; i >= 0; i--) {
			if (key.equals(keys.get(i))) {
				next = true;
			} else if (next) {
				return keys.get(i);
			}
		}
		
		return null;
	}
	
	public Integer rangeKey(Integer k1, Integer k2) {
		ArrayList<Integer> keys = allKeys();
		
		int count = 0;
		boolean start = false;
		
		for (Integer key : keys) {
			if (key.equals(k1)) start = true;
			else if (key.equals(k2)) start = false;
			else if (start) count++;
		}
		
		return count;
	}
	
	public void setSMARTThreshold(Integer th) {
		threshold = th;
	}
	
public static void main(String[] args) {
		
		CREA2 table = new CREA2();
//		
//		for (int i = 0; i < 100; i++) {
//			table.add(i, i);
//		}
//		
//		for (int i = 0; i < 100; i++) {
//			System.out.println(table.remove(i));
//		}
		table.add(3456789, "Polina");
		System.out.println("ID: "+ table.allKeys().get(0) +" Name: " + table.remove(3456789));
	}
}
