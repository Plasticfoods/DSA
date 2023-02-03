package Recursion;

import linkedList.Node;

public class ReverseList {
    public static void main(String[] args) {

        Node<Integer> head = new Node<>(5);
        Node<Integer> first = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(8);
        Node<Integer> fourth = new Node<>(11);
        Node<Integer> fifth = new Node<>(6);

        head.next = first;  first.next = second;  second.next = third;  third.next = fourth;  fourth.next = fifth;
        InsertNode.display(head);

        head = reverseList(head);
        InsertNode.display(head);
    }

    public static Node<Integer> reverseList(Node<Integer> head) {
        if(head == null || head.next == null)
            return head;

        Node<Integer> newhead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newhead;
    }
}
