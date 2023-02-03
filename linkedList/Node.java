package linkedList;

public class Node<T> {
    public T data;
    public Node next;

    public Node(){ }

    public Node(T data){
        this.data = data;
        next = null;
    }

    public static<T> Node<T> getNode(Node<T> head, int pos, int si){
        if(pos == si)
            return head;

        Node<T> ptr = head;
        int count = si;

        while(count<pos && ptr!=null){
            ptr = ptr.next;
            count++;
        }

        if(pos<si || ptr==null){
            System.out.println("PosOutOfIndex");
            return null;
        }

        return ptr;
    }

    public static<T> void display(Node<T> head){
        Node<T> ptr = head;

        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr = ptr.next;
        }

        System.out.println();
    }

}
