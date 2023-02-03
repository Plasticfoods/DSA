package garbage;

public class ArrayQueue {
	private int[] arr;
	private int front;
	private int rear;
	private int capacity;
	
	ArrayQueue() {
		capacity = 5;
		arr = new int[capacity];
		front = 0;
		rear = 0;
	}
	
	int size() {
		return rear-front;
	}
	
	boolean isEmpty() {
		if(front == rear)
			return true;
		else
			return false;
	}
	
	void add(int data) {
		if(rear == capacity) {
			reSize();
		}
		arr[rear++] = data;
	}
	
	int remove() throws Exception {
		if(isEmpty()) {
			throw new Exception("Queue is Empty!");
		}
		front++;
		return arr[front-1];
	}
	
	int peek() throws Exception {
		if(isEmpty()) {
			throw new Exception("Queue is Empty!");
		}
		return arr[front];
	}
	
	private void reSize() {
		int[] temp = arr;
		capacity = 2*capacity;
		arr = new int[capacity];		
		for(int i=0 ; i<temp.length ; i++) {
			arr[i] = temp[i];
		}
	}
}















