package garbage;
import java.util.ArrayList;

public class ArrayStack<E> {
	private ArrayList<E> arr;
	
	public ArrayStack () {
		arr = new ArrayList<>();
	}
	
	public int size() {
		return arr.size();
	}
	
	public void push(E data) {
		arr.add(data);
	}
	
	public E pop() throws Exception {
		if(arr.size() == 0) {
			throw new Exception("No element in stack");
		}
		else {
			int top = arr.size()-1;
			E temp = arr.get(top);
			arr.remove(top);
			return temp;
		}
	}
	
	public E peek() throws Exception {
		if(arr.size() == 0) {
			throw new Exception("No element in stack");
		}
		else {
			return arr.get(arr.size()-1);
		}
	}
}
