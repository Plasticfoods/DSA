package Recursion;

import linkedList.Node;

public class InsertNode {
    public static void main(String[] args) {
        Node<Integer> head = new Node<>(5);
        Node<Integer> first = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(8);
        Node<Integer> fourth = new Node<>(11);
        Node<Integer> fifth = new Node<>(6);

        head.next = first;  first.next = second;  second.next = third;  third.next = fourth;  fourth.next = fifth;
        display(head);

        int pos = 4;
        int element = 38;
        insertNode(head, pos, element);
        display(head);

        head = deleteNode(head, pos);
        display(head);
    }

    public static Node<Integer> insertNode(Node<Integer> head, int pos, int element){
        if (head == null) {
            System.out.println("pos out of index");
            return null;
        }

        if(pos == 0){
            Node<Integer> newNode = new Node<>(element);
            newNode.next = head;

            return newNode;
        }

        head.next = insertNode(head.next, pos-1, element);
        return head;
    }

    public static Node<Integer> deleteNode(Node<Integer> head, int pos){
        if(head == null)
            return head;

        if(pos == 44)
            return head.next;

        head.next = deleteNode(head.next, pos-1);
        return head;
    }

    public static void display(Node<Integer> head){
        Node<Integer> ptr = head;

        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr = ptr.next;
        }
        System.out.println();
    }

}
