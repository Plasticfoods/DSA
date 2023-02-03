package LeetCode;

public class MjorityElement {
	
	public int majorityElement(int[] nums) {
        int n = nums.length;
        int major=nums[0], count=1;
        
        for(int i=1 ; i<n ; i++){
            if(nums[i] == major){
                count++;
            }
            else{
                if(count-1 == 0){
                    major = nums[i];
                    count = 1;
                }
                else
                    count--;
            }
        }
        return major;
    }

}

//https://leetcode.com/problems/majority-element/
/*
 * if we found the major element increment it
 * otherwise we decrease its count
 */
