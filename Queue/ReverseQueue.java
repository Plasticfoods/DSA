package Queue;
import java.util.Queue;
import java.util.LinkedList;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(11);
        q.add(12);
        q.add(13);
        q.add(14);

        System.out.println(q.peek()+" "+q.size());

        reverseQueue(q);
        System.out.println(q.peek()+" "+q.size());
    }

    public static void reverseQueue(Queue<Integer> input) {
        //Your code goes here
        int i;

        if(input.size()>0){
            i = input.poll();
            reverseQueue(input);
            input.add(i);
        }
    }


}
