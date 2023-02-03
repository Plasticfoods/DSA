package Arrays;

public class MaximumSubArray {
	
	//kaden's algo
	public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i=0 ; i<nums.length ; i++) {
        	currSum = currSum + nums[i];
        	if(currSum > maxSum)
        		maxSum = currSum;
        	if(currSum < 0)
        		currSum = 0;
        }
        return maxSum;
    }

}
