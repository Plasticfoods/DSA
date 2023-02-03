package PriorityQueue;
import garbage.A;

import java.util.ArrayList;

public class MaxPriorityQueue {
    private ArrayList<Integer> heap;

    public MaxPriorityQueue(){
        heap = new ArrayList<>();
    }

    boolean isEmpty() {
        return heap.size()==0;
    }

    int getSize() {
        return heap.size();
    }

    int getMax() {
        if(heap.size()==0)
            return Integer.MIN_VALUE;
        return heap.get(0);
    }

    void insert(int element) {
        heap.add(element);
        int childIndex = heap.size()-1;
        int parentIndex = (childIndex-1)/2;

        while(childIndex > 0) {
            if(heap.get(parentIndex) > heap.get(childIndex))
                break;

            int temp = heap.get(childIndex);
            heap.set(childIndex,heap.get(parentIndex));
            heap.set(parentIndex,temp);

            childIndex = parentIndex;
            parentIndex = (childIndex-1)/2;
        }
    }

    int removeMax() {
        if(heap.size()==0)
            return Integer.MIN_VALUE;
        int r = heap.get(0);
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int midIndex = 0;
        int leftChildIndex = 1;
        int rightChildIndex = 2;

        while(leftChildIndex < heap.size()) {
            int currIndex = midIndex;
            if(heap.get(midIndex)<heap.get(leftChildIndex))
                midIndex = leftChildIndex;
            else if(rightChildIndex<heap.size() && heap.get(midIndex)<heap.get(rightChildIndex))
                midIndex = rightChildIndex;
            else
                break;

            int temp = heap.get(midIndex);
            heap.set(midIndex,heap.get(currIndex));
            heap.set(currIndex,temp);

            leftChildIndex = 2*midIndex + 1;
            rightChildIndex = 2*midIndex + 2;
        }

        return r;
    }

}
