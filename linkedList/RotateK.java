package linkedList;

public class RotateK {
    public static void main(String[] args) {
        Node<Integer> head = new Node<>(1);
        Node<Integer> first = new Node<>(2);
        Node<Integer> second = new Node<>(3);
        Node<Integer> third = new Node<>(4);
        Node<Integer> fourth = new Node<>(5);
        //Node<Integer> fifth = new Node<>(6);

        head.next = first;  first.next = second;  second.next = third;  third.next = fourth;  //fourth.next = fifth;
        Node.display(head);

        head = rotateRight(head, 4);
        Node.display(head);
    }

    public static Node<Integer> rotateRight(Node<Integer> head, int k) {
        if(head==null || head.next==null)
            return head;

        int listSize = getSize(head);
        k = k%listSize;
        if(k<=0)
            return head;

        Node<Integer> newtail = getNode(head, listSize-k-1);
        Node<Integer> tail = head;
        while(tail.next!=null){
            tail = tail.next;
        }

        Node<Integer> newhead = newtail.next;
        newtail.next = null;
        tail.next = head;

        return newhead;
    }

    private static int getSize(Node<Integer> head){
        if(head==null)
            return 0;

        int count=0;
        Node<Integer> ptr = head;
        while(ptr!=null){
            ptr = ptr.next;
            count++;
        }

        return count;
    }

    private static Node<Integer> getNode(Node<Integer> head, int pos){
        if(head==null || pos<0)
            return null;

        Node<Integer> ptr = head;
        int count=0;
        while(ptr!=null && count<pos){
            ptr = ptr.next;
            count++;
        }

        if(ptr==null)
            return null;

        return ptr;
    }
}
