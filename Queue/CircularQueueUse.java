package Queue;
import java.util.Scanner;

public class CircularQueueUse {
    public static void main(String[] args) throws QueueFullException {
        int choice = 0;
        CircularQueue q = new CircularQueue(3);
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println();
            System.out.print("1. peek\n");
            System.out.print("2. enqueue\n");
            System.out.print("3. dequeue\n");
            System.out.print("4 to get size\n");
            System.out.print("0. to exit\n");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice){
                case 1:
                        try{
                            System.out.println(q.front());
                        }
                        catch(QueueEmptyException e){
                            e.getMessage("Queue is empty");
                        }
                    break;

                case 2:
                        if(q.isFull())
                            System.out.println("Queue is full");
                        else {
                            System.out.print("Enter data: ");
                            q.enqueue(sc.nextInt());
                        }
                    break;

                case 3:
                        try{
                            System.out.println("deleted data: "+q.dequeue());
                        }
                        catch (QueueEmptyException e){
                            e.getMessage("Queue is empty");
                        }

                case 4:
                        System.out.println(q.size());
                    break;
            }
        }while(choice!=0);
    }
}
