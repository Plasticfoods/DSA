package linkedList;

public class PalindromeList {
    public static void main(String[] args) {
        Node<Integer> head = new Node<>(5);
        Node<Integer> first = new Node<>(1);
        Node<Integer> second = new Node<>(1);
        Node<Integer> third = new Node<>(1);
        Node<Integer> fourth = new Node<>(2);
        Node<Integer> fifth = new Node<>(5);

        head.next = first;  first.next = second;  second.next = third;  third.next = fourth;  fourth.next = fifth;
        System.out.println(checkPalindrome(head));

    }


    public static boolean checkPalindrome(Node<Integer> head) {
        if(head == null)
            return true;

        Node<Integer> midNode = getMidNode(head);
        Node<Integer> last = ReverseList.reverseList(midNode.next);

        Node<Integer> curr = head;
        while(last != null){
            if(curr.data != last.data)
                return false;

            last = last.next;
            curr = curr.next;
        }

        return true;
    }

    public static Node<Integer> getMidNode(Node<Integer> head){
        Node<Integer> slow = head;
        Node<Integer> fast = head;

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
