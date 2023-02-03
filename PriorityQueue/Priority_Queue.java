package PriorityQueue;
import java.util.ArrayList;

public class Priority_Queue {
    private ArrayList<Integer> heap;

    public Priority_Queue(){
        heap = new ArrayList<>();
    }

    int size(){
        return heap.size();
    }

    int getMin() throws EmptyPriorityQueueException {
        if(heap.size()==0)
            throw new EmptyPriorityQueueException();

        return heap.get(0);
    }

    void insert(int element){
        heap.add(element);
        int childIndex = heap.size()-1;
        int parentIndex = (childIndex-1)/2;

        while(childIndex > 0){
            if(heap.get(childIndex)>heap.get(parentIndex))
                break;
            int temp = heap.get(childIndex);
            heap.set(childIndex,heap.get(parentIndex));
            heap.set(parentIndex,temp);

            childIndex = parentIndex;
            parentIndex = (childIndex-1)/2;
        }
    }

    int remove() throws EmptyPriorityQueueException {
        if(heap.size()==0)
            throw new EmptyPriorityQueueException();

        int r = heap.get(0);
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int rootIndex = 0;
        int leftChildIndex = 1;
        int rightChildIndex = 2;

        while(leftChildIndex < heap.size()){
            int currIndex = rootIndex;
            if(heap.get(leftChildIndex)<heap.get(currIndex))
                currIndex = leftChildIndex;
            if(rightChildIndex<heap.size() && heap.get(rightChildIndex)<heap.get(currIndex))
                currIndex = rightChildIndex;
            if(currIndex==rootIndex)
                break;

            int temp = heap.get(currIndex);
            heap.set(currIndex,heap.get(rootIndex));
            heap.set(rootIndex,temp);

            leftChildIndex = currIndex*2 + 1;
            rightChildIndex = currIndex*2 + 2;
        }

        return r;
    }

}
