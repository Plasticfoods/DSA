import java.util.*;

class ShuffleArray {
    private int[] input;

    public Solution(int[] nums) {
        input = nums;
    }
    
    public int[] reset() {
        return input;
    }
    
    public int[] shuffle() {
        int[] arr = new int[input.length];

        for(int i=0 ; i<input.length ; i++) {
            arr[i] = input[i];
        }
        return shuffle(arr, arr.length);
    }

    private int[] shuffle(int[] arr, int n) {
        Random r = new Random();
         
        for (int i = n-1; i > 0; i--) {
            int j = r.nextInt(i+1);
             
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        return arr;
    }
    
}