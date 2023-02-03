package General;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {

	//two pointer approach
	public static List<List<Integer>> threeSum(int[] nums) {
		int n = nums.length;
		if(n<3)
			return null;
		
		Arrays.sort(nums);
		List<List<Integer>> output = new ArrayList<>();
		
		for(int i=0 ; i<n-2 ; i++) {
			if(i>0 && nums[i]==nums[i-1])
				continue;
			int rest = 0-nums[i];
			int lo=i+1, hi=n-1;
			
			while(lo < hi) {
				if(nums[lo]+nums[hi] == rest) {
					List<Integer> arrTemp = new ArrayList<>();
					arrTemp.add(nums[i]);
					arrTemp.add(nums[lo]);
					arrTemp.add(nums[hi]);
					output.add(arrTemp);
					lo++;
					hi--;
					while(lo<hi && nums[lo]==nums[lo-1])
						lo++;
					while(lo<hi && nums[hi]==nums[hi+1])
						hi--;
				}
				
				if(lo>=hi)
					break;
				if(nums[lo]+nums[hi] < rest)
					lo++;
				else if(nums[lo]+nums[hi] > rest)
					hi--;
			}
		}
		return output;
    }
	
	
	


	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		List<List<Integer>> list = threeSum(nums);
		System.out.println(list);
	}

}
