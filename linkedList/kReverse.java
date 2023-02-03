package linkedList;
import static linkedList.ReverseList.reverseList;

public class kReverse {
    public static void main(String[] args) {
        Node<Integer> head = new Node<>(1);
        Node<Integer> first = new Node<>(2);
        Node<Integer> second = new Node<>(3);
        Node<Integer> third = new Node<>(4);
        Node<Integer> fourth = new Node<>(5);
        Node<Integer> fifth = new Node<>(6);
        Node<Integer> sixth = new Node<>(7);

        head.next = first;  first.next = second;  second.next = third;  third.next = fourth;  fourth.next = fifth;  fifth.next = sixth;
        Node.display(head);

        head = kReverse(head, 2);
        Node.display(head);
    }


    public static Node<Integer> kReverse(Node<Integer> head, int k){
        if(head==null || k<=1)
            return head;

        Node<Integer> start = head;
        Node<Integer> end = null;

        Node<Integer> temp = head;
        int count=1;
        while(temp!=null && count<k){
            temp = temp.next;
            count++;
        }
        end = temp;

        if(temp==null)
            return head;

        Node<Integer> nextNode = kReverse(end.next, k);
        end.next = null;

        head = reverseList(start);
        start.next = nextNode;

        return head;
    }
}
