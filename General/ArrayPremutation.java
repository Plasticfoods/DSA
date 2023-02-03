package General;
import java.util.List;
import java.util.ArrayList;

public class ArrayPremutation {
	
	public static List<List<Integer>> permutation(int[] nums) {
		if(nums.length == 0) {
			return new ArrayList<>();
		}
		if(nums.length == 1) {
			List<Integer> temp = new ArrayList<>();
			temp.add(nums[0]);
			List<List<Integer>> res = new ArrayList<>();
			res.add(temp);
			return res;
		}
		
		List<List<Integer>> res = new ArrayList<>();
		for(int i=0 ; i<nums.length ; i++) {
			int[] nums2 = removeIndex(nums,i);
			List<List<Integer>> subList = permutation(nums2);
			
			for(int j=0 ; j<subList.size() ; j++) {
				List<Integer> temp = subList.get(j);
				temp.add(0,nums[i]);
			}
			res.addAll(subList);
		}
		
		return res;
	}

	private static int[] removeIndex(int[] nums, int i) {
		int[] nums2 = new int[nums.length-1];
		int j=0, k=0;
		while(j < nums.length) {
			if(j!=i) {
				nums2[k] = nums[j];
				k++;
			}
			j++;
		}
		return nums2;
	}
	
	public static void main(String[] args) {
		int[] nums = {4,1,2,3};
		List<List<Integer>> res = permutation(nums);
		System.out.println(res);
	}
}
