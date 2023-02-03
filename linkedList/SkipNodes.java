package linkedList;

public class SkipNodes {
    public static void main(String[] args) {
        Node<Integer> head = new Node<>(5);
        Node<Integer> first = new Node<>(1);
        Node<Integer> second = new Node<>(11);
        Node<Integer> third = new Node<>(7);
        Node<Integer> fourth = new Node<>(5);
        Node<Integer> fifth = new Node<>(9);

        head.next = first;  first.next = second;  second.next = third;  third.next = fourth;  fourth.next = fifth;

        int n=4;
        Node<Integer> temp = skip(first.next, n);

        if(temp!=null)
            System.out.println(temp.data);
        else
            System.out.println("null");
    }

    public static Node<Integer> skip(Node<Integer> head, int n){
        int count=1;

        while(head!=null && count!=n){
            head = head.next;
            count++;
        }

        return head.next;
    }
}
