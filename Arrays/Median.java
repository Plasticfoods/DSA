package Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
/*
    You are given a stream of 'N' integers. For every 'i-th' integer added to the running list of integers,
    print the resulting median.

    arr = {6 4 2 2 3 4}
    S = {6}, median = 6
    S = {6, 2} -> {2, 6}, median = 4
    S = {6, 2, 1} -> {1, 2, 6}, median = 2
    S = {6, 2, 1, 3} -> {1, 2, 3, 6}, median = 2
    S = {6, 2, 1, 3, 7} -> {1, 2, 3, 6, 7}, median = 3
    S = {6, 2, 1, 3, 7, 5} -> {1, 2, 3, 5, 6, 7}, median = 4
 */


public class Median {
    public static void findMedian(int arr[])  {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        for(int i=0 ; i<arr.length ; i++){
            int e = arr[i];
            //insertion
            if(maxPQ.size()==0 && minPQ.size()==0)
                maxPQ.add(e);
            else if(e>maxPQ.peek())
                minPQ.add(e);
            else
                maxPQ.add(e);

            //Re-arrangement PQs
            if(maxPQ.size()-minPQ.size()>1)
                minPQ.add(maxPQ.remove());
            if(minPQ.size()-maxPQ.size()>1)
                maxPQ.add(minPQ.remove());

            //get median
            int median=0;
            if(maxPQ.size()>minPQ.size())
                median = maxPQ.peek();
            else if(minPQ.size()>maxPQ.size())
                median = minPQ.peek();
            else
                median = (maxPQ.peek()+minPQ.peek())/2;

            System.out.print(median+" ");
        }

    }

}
