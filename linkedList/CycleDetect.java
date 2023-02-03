package linkedList;

public class CycleDetect {
    public static void main(String[] args) {
        Node<Integer> head = new Node<>(1);
        Node<Integer> first = new Node<>(2);
        Node<Integer> second = new Node<>(5);
        Node<Integer> third = new Node<>(10);
        Node<Integer> fourth = new Node<>(8);
        Node<Integer> fifth = new Node<>(6);

        head.next = first;  first.next = second;  second.next = third;  third.next = fourth;  fourth.next = fifth; fifth.next = first;
        System.out.println(cycleDetect(head));
        System.out.println(cycleLength(head));
    }

    public static boolean cycleDetect(Node<Integer> head){
        if(head == null)
            return false;

        Node<Integer> fast = head;
        Node<Integer> slow = head;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow)
                return true;
        }

        return false;
    }

    public static int cycleLength(Node<Integer> head){
        Node<Integer> fast = head;
        Node<Integer> slow = head;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow)
                break;
        }

        if(fast == null)
            return 0;

        int count=0;
        do{
            slow = slow.next;
            count++;
        }while(fast!=slow);

        return count;
    }
}
