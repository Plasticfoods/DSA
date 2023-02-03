package PriorityQueue;

public class Main {
    public static void main(String[] args) throws EmptyPriorityQueueException {
        HeapSort h = new HeapSort();
        int[] arr = {4,6,7,1,2};
        h.sort(arr);
        for(int i=0 ; i<arr.length ; i++)
        {
            System.out.print(arr[i]+" ");
        }
    }

}
