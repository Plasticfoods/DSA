package linkedList;

public class ReverseList2 {
    public static void main(String[] args) {
        Node<Integer> head = new Node<>(5);
        Node<Integer> first = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(8);
        Node<Integer> fourth = new Node<>(11);
        Node<Integer> fifth = new Node<>(6);

        head.next = first;  first.next = second;  second.next = third;  third.next = fourth;  fourth.next = fifth;
        Node.display(head);

        head = reverseList2(head);
        Node.display(head);
    }


    static Node<Integer> reverseList2(Node<Integer> head) {
        if(head == null || head.next == null)
            return head;

        Node<Integer> newhead = null;
        Node<Integer> newtail = null;

        while(newhead != head)
        {
            Node<Integer> ptr = head;
            while(ptr.next != newtail)
                ptr = ptr.next;

            if(newhead == null) {
                newhead = ptr;
                newtail = ptr;
            }
            else {
                newtail.next = ptr;
                newtail = newtail.next;
                newtail.next = null;
            }

        }

        return newhead;
    }

}
