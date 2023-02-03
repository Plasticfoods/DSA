package linkedList;

public class MergeSort {
    public static void main(String[] args) {
        Node<Integer> head = new Node<>(5);
        Node<Integer> first = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(8);
        Node<Integer> fourth = new Node<>(11);
        Node<Integer> fifth = new Node<>(6);

        head.next = first;  first.next = second;  second.next = third;  third.next = fourth;  fourth.next = fifth;
        display(head);

        head = mergeSort(head);
        display(head);

    }


    public static Node<Integer> mergeSort(Node<Integer> head){
        if(head == null || head.next == null)
            return head;

        Node<Integer> midNode = getMidNode(head);
        Node<Integer> head2 = midNode.next;

        head2 = mergeSort(head2);
        midNode.next = null;
        head = mergeSort(head);

        head = merge(head, head2);
        return head;
    }


    static Node<Integer> getMidNode(Node<Integer> head){
        if(head == null || head.next == null)
            return head;

        Node<Integer> slow = head;
        Node<Integer> fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    static Node<Integer> merge(Node<Integer> head1, Node<Integer> head2){
        if(head1 == null)
            return head2;

        if(head2 == null)
            return head1;

        Node<Integer> head = null;
        Node<Integer> tail = null;

        if(head1.data < head2.data)
        {
            head = head1;
            head1 = head1.next;
        }
        else
        {
            head = head2;
            head2 = head2.next;
        }
        tail = head;

        while(head1!=null && head2!=null)
        {
            if(head1.data<head2.data)
            {
                tail.next = head1;
                head1 = head1.next;
            }

            else{
                tail.next = head2;
                head2 = head2.next;
            }

            tail = tail.next;
        }


        if(head1==null)
            tail.next = head2;

        if(head2==null)
            tail.next = head1;


        return head;
    }

    static void display(Node<Integer> head){
        Node<Integer> ptr = head;

        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr = ptr.next;
        }
        System.out.println();
    }
}
