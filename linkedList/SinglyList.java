package linkedList;
import java.util.Scanner;

public class SinglyList {
    static Node<Integer> head = null;
    static Node<Integer> tail = null;

    public static void main(String[] args) {
        Node<Integer> head = null;
        Node<Integer> tail = null;

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        int data, pos = -1;

        do{
            System.out.println();
            System.out.println("1 to create node");
            System.out.println("2 to display list");
            System.out.println("3 to insert a node at any position");
            System.out.println("4 to delete node at any position");
            System.out.println("5 to get the middle node");
            System.out.println("6 to reverse list");
            System.out.println("0 to exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice){
                case 1:
                        System.out.print("Enter data:");
                        data = sc.nextInt();
                        createNode(data);
                    break;

                case 2: display();
                    break;

                case 3: System.out.print("Enter the position to insert:");
                        pos = sc.nextInt();
                        insert(pos);
                    break;

                case 4:
                        System.out.print("Enter the position of the node to delete: ");
                        pos = sc.nextInt();
                        delete(pos);
                    break;

                case 5: Node<Integer> temp = getMidNode();
                        System.out.println("Middle node data is "+temp.data);
                    break;

                case 6: head = reverseNode();
                        display();
                    break;
            }


        }while(choice>0 && choice<=6);
    }


    static void createNode(int data){
        Node<Integer> newNode = new Node<>(data);

        if(head == null){
            head = newNode;
            return;
        }

        if(tail == null) {
            tail = newNode;
            head.next = tail;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    static void display(){
        Node<Integer> ptr = head;
        int count=0;

        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr = ptr.next;
            count++;
        }

        System.out.println("\nNumber of nodes = "+count);
    }

    static void insert(int pos){
        Scanner sc = new Scanner(System.in);
        Node<Integer> newNode = new Node<>();
        System.out.println("Enter data:");
        newNode.data = sc.nextInt();

        Node<Integer> left = Node.getNode(head, pos-1,0);

        if(pos == 0){
            newNode.next = head;
            head = newNode;
            System.out.println("After insertion");
            display();
            return;
        }

        if(left == null){
            System.out.println("PosOutOfIndex");
            display();
            return;
        }

        if(left.next == null){
            left.next = newNode;
            tail = newNode;
            System.out.println("After insertion");
            display();
            return;
        }

        Node<Integer> right = left.next;
        left.next = newNode;
        newNode.next = right;
        System.out.println("After insertion");
        display();
    }

    static void delete(int pos){
        if(head == null)
            return;

        if(pos == 0){
            if(head.next!=null)
                head = head.next;
        }
        else{
            Node<Integer> temp = Node.getNode(head, pos-1, 0);
            if(temp==null)
                return;

            if(temp.next!=null)
                temp.next = temp.next.next;

            System.out.println("After deletion");
            display();
        }

    }

    static Node<Integer> getMidNode(){
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

    static Node<Integer> reverseNode(){
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
        head = left;

        return head;
    }


}
