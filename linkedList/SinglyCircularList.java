package linkedList;
import java.util.Scanner;

public class SinglyCircularList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        int size = 0, pos = -1;
        Node<Integer> head = null;

        do{
            System.out.println("\n1 to create node");
            System.out.println("2 to dispaly");
            System.out.println("3 to insert node");
            System.out.println("4 to delete node");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch(choice){
                case 1: head = createNode(head);
                        size++;
                    break;

                case 2: display(head);
                    break;

                case 3: System.out.print("Enter the position to insert: ");
                        pos = sc.nextInt();
                        head = insert(head, pos);
                        size++;
                        display(head);
                    break;

                case 4: System.out.print("Enter the position to delete: ");
                        pos = sc.nextInt();
                        head = delete(head, pos);
                        size--;
                        display(head);
                    break;
            }
            System.out.println("size of list = "+size);

        }while(choice!=0);
    }

    static Node<Integer> createNode(Node<Integer> head){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter data: ");
        Node<Integer> newNode = new Node(sc.nextInt());

        if(head == null)
        {
            head = newNode;
            head.next = head;
            return head;
        }

        Node<Integer> ptr = head;
        while(ptr.next != head){
            ptr = ptr.next;
        }

        ptr.next = newNode;
        newNode.next = head;

        return head;
    }

    static void display(Node<Integer> head){
        Node<Integer> ptr = head;

        do{
            System.out.print(ptr.data+" ");
            ptr = ptr.next;
        }while(ptr != head);
        System.out.println();
    }

    static Node<Integer> insert(Node<Integer> head, int pos){
        if(head == null){
            System.out.println("List is empty");
            return null;
        }

        int count=0;
        Node<Integer> ptr = head;
        while(ptr.next != head){
            ptr = ptr.next;
            count++;
        }

        // checking if the position is valid
        if(count<pos-1 || pos<0){
            System.out.println("pos out of index");
            return head;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter data: ");
        Node<Integer> newNode = new Node(sc.nextInt());

        //already pos = last node
        if(pos == 0){
            ptr.next = newNode;
            newNode.next = head;

            return newNode;
        }

        if(count == pos-1){
            ptr.next = newNode;
            newNode.next = head;

            return head;
        }

        Node<Integer> left = getNode(head, pos-1);
        Node<Integer> right = left.next;

        left.next = newNode;
        newNode.next = right;

        return head;
    }

    static Node<Integer> delete(Node<Integer> head, int pos) {
        if(head == null){
            System.out.println("list is empty");
            return head;
        }

        int count=0;
        Node<Integer> ptr = head;
        while(ptr.next != head){
            ptr = ptr.next;
            count++;
        }
        if(pos>count || pos<0){
            System.out.println("pos out of index");
            return head;
        }


        if(pos == 0){
            ptr.next = ptr.next.next;
            return ptr.next;
        }

        Node<Integer> left = getNode(head, pos-1);
        left.next = left.next.next;

        return head;
    }


    static Node<Integer> getNode(Node<Integer> head, int pos){
        Node<Integer> ptr = head;
        int count=0;

        while(count<pos) {
            ptr = ptr.next;
            count++;
        }

        return ptr;
    }




}
