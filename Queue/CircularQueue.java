package Queue;

public class CircularQueue {
    private int rear;
    private int front;
    private int[] arr;
    private int size;

    CircularQueue(int capacity){
        this.rear = -1;
        this.front = 0;
        arr = new int[capacity];
        size = 0;
    }

    int size(){
        return  size;
    }

    void enqueue(int data) throws QueueFullException {
        if(size==arr.length)
            throw new QueueFullException();

        rear = (rear+1) % arr.length;
        arr[rear] = data;
        size++;
    }

    int dequeue() throws QueueEmptyException {
        if(size==0)
            throw new QueueEmptyException();

        int temp = arr[front];
        front = (front+1) % arr.length;
        size--;

        return temp;
    }

    int front() throws QueueEmptyException {
        if(size==0)
            throw new QueueEmptyException();

        return arr[front];
    }

    boolean isEmpty(){
        return (size==0);
    }

    boolean isFull(){
        return size==arr.length;
    }
}
