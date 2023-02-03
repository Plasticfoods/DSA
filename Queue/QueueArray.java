package Queue;

public class QueueArray {
    private int rear;
    private int front;
    private int[] arr;
    private int size;

    public QueueArray(){
        this.rear = -1;
        this.front = 0;

        arr = new int[5];
        size=0;
    }

    public QueueArray(int a){
        this.rear = -1;
        this.front = 0;

        arr = new int[a];
        size=0;
    }

    int size(){
        return size;
    }

    boolean isEmpty(){
        return (size==0);
    }

    boolean isFull(){
        return (size==arr.length);
    }

    void enqueue(int data) throws QueueFullException{
        if(isFull())
            throw new QueueFullException();

        if(size==0){
            rear = -1;
            front = 0;
        }

        arr[++rear] = data;
        size++;
    }

    int dequeue() throws QueueEmptyException{
        if(isEmpty())
            throw new QueueEmptyException();

        int temp = arr[front];
        front++;
        size--;

        return temp;
    }

    int front() throws QueueEmptyException{
        if(isEmpty())
            throw new QueueEmptyException();

        return arr[front];
    }
}
