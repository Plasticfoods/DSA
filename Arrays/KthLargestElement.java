package Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {
	
	public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQueue= new PriorityQueue<>();
        
        for(int i=0 ; i<k ; i++) {
            pQueue.add(nums[i]);
        }
        
        for(int i=k ; i<nums.length ; i++) {
        	if(nums[i] > pQueue.peek()) {
        		pQueue.poll();
        		pQueue.add(nums[i]);
        	}
        }
        
        return pQueue.peek();
    }
	
	public static void main(String[] args) {
		int[] nums = {3,2,1,5,6,4};
		int k = 3;
		System.out.println(findKthLargest(nums, k));
	}
}
