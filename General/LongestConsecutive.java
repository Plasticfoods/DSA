package General;
import java.util.HashSet;

public class LongestConsecutive {
	
	public static int longestConsecutive(int[] nums) {
        if(nums.length == 0)
        	return 0;
        
        HashSet<Integer> set = new HashSet<>();
        for(int i=0 ; i<nums.length ; i++) {
        	set.add(nums[i]);
        }
        
        int len = 1;
        for(int i=0 ; i<nums.length ; i++) {
        	if(set.contains(nums[i])) {
        		int num = nums[i];
        		int currLen = 1;
        		
        		while(set.contains(num-1)) {
        			set.remove(num-1);
        			currLen++;
        			num--;
        		}
        		
        		num = nums[i];
        		while(set.contains(num+1)) {
        			set.contains(num+1);
        			currLen++;
        			num++;
        		}
        		
        		len = Math.max(len, currLen);
        	}
        }
        
        
        return len;
    }
	
	
	public static void main(String[] args) {
		int[] nums = {0,3,7,2,5,8,4,6,0,1};
		System.out.println(longestConsecutive(nums));
	}
	
	
	
	
	
	
	
	
	
	
	
}
