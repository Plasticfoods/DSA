package linkedList;

public class ReverseList {
    public static void main(String[] args) {
        Node<Integer> head = new Node<>(1);
        Node<Integer> first = new Node<>(2);
        Node<Integer> second = new Node<>(3);
        Node<Integer> third = new Node<>(4);
        Node<Integer> fourth = new Node<>(5);
        Node<Integer> fifth = new Node<>(6);

        head.next = first;  first.next = second;  second.next = third;  third.next = fourth;  fourth.next = fifth;
        Node.display(head);

        head = reverseList(head);
        Node.display(head);
    }


    public static Node<Integer> reverseList(Node<Integer> head) {
        if(head == null)
            return head;

        Node<Integer> left = null;
        Node<Integer> right = null;

        while(head!=null){
            right = head.next;
            head.next = left;
            left = head;
            head = right;
        }

        return left;
    }


}
