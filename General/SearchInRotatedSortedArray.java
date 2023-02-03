package General;

public class SearchInRotatedSortedArray {
	
	public static int search(int[] nums, int target) {
		int lo=0, hi=nums.length-1;
		
		while(lo <= hi) {
			int mid = lo + (hi-lo)/2;
			if(target == nums[mid])
				return mid;
			
			//is left part is sorted
			if(nums[lo] <= nums[mid]) {
				if(nums[lo]<=target && target<=nums[mid])
					hi = mid-1;
				else
					lo = mid+1;
			}
			//otherwise right part must be sorted
			else {
				if(nums[mid]<=target && target<=nums[hi])
					lo = mid+1;
				else
					hi = mid-1;
				
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] nums = {5,1,3};
		int target = 3;
		System.out.println(search(nums,target));
	}
}
