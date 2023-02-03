package PriorityQueue;

public class HeapSort {
	
    public void sort(int[] arr){
        //up-heapify
        for(int i=0 ; i<arr.length ; i++) {
            insertVirtually(arr, i);
        }

        //down-heapify
        int heapSize = arr.length;
        for(int i=0 ; i<arr.length ; i++){
            removeVirtually(arr,heapSize);
            heapSize--;
        }
    }

    private void removeVirtually(int[] arr, int heapSize) {
        int lastE = arr[0];
        arr[0] = arr[heapSize-1];

        //virtually last element deleted
        arr[heapSize-1] = lastE;
        heapSize--;

        int rootIndex = 0;
        int leftChildIndex = 1;
        int rightChildIndex = 2;

        while(leftChildIndex < heapSize){
            int currIndex = rootIndex;
            if(arr[currIndex] < arr[leftChildIndex])
                currIndex = leftChildIndex;
            if(rightChildIndex<heapSize && arr[currIndex]<arr[rightChildIndex])
                currIndex = rightChildIndex;
            if(currIndex == rootIndex)
                break;

            int temp = arr[currIndex];
            arr[currIndex] = arr[rootIndex];
            arr[rootIndex] = temp;

            rootIndex = currIndex;
            leftChildIndex = 2*rootIndex + 1;
            rightChildIndex = 2*rootIndex + 2;
        }
    }

    private void insertVirtually(int[] arr, int i) {
        int childIndex = i;
        int parentIndex = (childIndex-1)/2;

        while(childIndex > 0) {
            if(arr[childIndex] > arr[parentIndex]){
                int temp = arr[childIndex];
                arr[childIndex] = arr[parentIndex];
                arr[parentIndex] = temp;

                childIndex = parentIndex;
                parentIndex = (childIndex-1)/2;
            }
            else
                break;
        }
    }

}
