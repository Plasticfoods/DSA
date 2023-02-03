package linkedList;

public class SwapNode {
    public static void main(String[] args) {
        Node<Integer> head = new Node<>(1);
        Node<Integer> first = new Node<>(2);
        Node<Integer> second = new Node<>(3);
        Node<Integer> third = new Node<>(4);

        head.next = first;  first.next = second;  second.next = third;
        Node.display(head);

        int i=1;
        int j=3;
        swapNodes(head, i, j);
        Node.display(head);
    }



    public static Node<Integer> swapNodes(Node<Integer> head, int i, int j) {
        if(head == null || i==j)
            return head;

        if(i>j){
            int temp = i;
            i = j;
            j = temp;
        }

        Node<Integer> inode = getNode(head, i);
        Node<Integer> jnode = getNode(head, j);
        //i1 = node just before ith node,  i2 = node just after ith node
        //j1 = node just before jth node,  j2 = node just after jth node

        if(i!=0){
            Node<Integer> i1 = getNode(head, i-1);

            if(j-i == 1){
                i1.next = jnode;
                inode.next = jnode.next;
                jnode.next = inode;

                return head;
            }

            Node<Integer> i2 = getNode(head, i+1);
            Node<Integer> j1 = getNode(head, j-1);
            Node<Integer> j2 = getNode(head, j+1);

            i1.next = jnode;
            jnode.next = i2;

            j1.next = inode;
            inode.next = j2;

            return head;
        }


        if(j-i == 1){
            inode.next = jnode.next;
            jnode.next = inode;

            return jnode;
        }

        Node<Integer> i2 = inode.next;
        Node<Integer> j1 = getNode(head, j-1);

        inode.next = jnode.next;
        j1.next = inode;

        jnode.next = i2;

        return jnode;
    }


    public static Node<Integer> getNode(Node<Integer> head, int n){
        int count=0;

        Node<Integer> curr = head;

        while(curr!=null && count<n){
            curr = curr.next;
            count++;
        }

        return curr;
    }


}
