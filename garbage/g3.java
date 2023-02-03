package garbage;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class g3 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(2);
        arr.add(8);
        arr.add(7);

        Max temp = new Max();

        Collections.sort(arr,temp);
        System.out.println(arr);

        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        maxPQ.add(4);
        maxPQ.add(5);
        maxPQ.add(6);
        System.out.println(maxPQ.remove()+" "+maxPQ.remove());
    }
}

class Max implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1<o2)
            return 1;
        if(o1>o2)
            return -1;
        return 0;
    }
}
