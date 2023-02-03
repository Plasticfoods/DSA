package Queue;
import java.util.Scanner;

public class Queue1 {
    public static void main(String[] args) {
        int choice=0;
        QueueArray q = new QueueArray(3);
        Scanner sc = new Scanner(System.in);

        do{
            System.out.print("1. peek\n");
            System.out.print("2. enqueue\n");
            System.out.print("3. dequeue\n");
            System.out.print("0. to exit\n");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                        try{
                            System.out.println(q.front());
                        }
                        catch(QueueEmptyException q1){
                            q1.getMessage("Queue is empty");
                        }
                    break;

                case 2:
                        try{
                            System.out.print("Enter data: ");
                            q.enqueue(sc.nextInt());
                        }
                        catch(QueueFullException q1){
                            q1.getMessage("Queue is full");
                        }
                    break;

                case 3:
                        try{
                            System.out.println(q.dequeue());

                        } catch (QueueEmptyException q1) {
                            q1.getMessage("ghak");
                        }
                    break;
            }
        }while(choice!=0);
    }
}
