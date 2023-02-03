package Queue;
import linkedList.Node;

public class QueueLL<T> {
    private Node<T> rear;
    private Node<T> front;
    private int size;

    public QueueLL(){
        rear = null;
        front = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public void push(T data){
        Node<T> temp = new Node(data);
        if(size==0){
            rear = temp;
            front = temp;
        }

        rear.next = temp;
        rear = rear.next;
        size++;
    }

    public T pop() throws QueueEmptyException {
        if(size==0)
            throw new QueueEmptyException();

        T temp = front.data;
        front = front.next;
        size--;

        return temp;
    }

    public T peek() throws QueueEmptyException {
        if(size==0)
            throw new QueueEmptyException();

        return front.data;
    }
}
