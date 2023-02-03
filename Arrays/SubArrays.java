package Arrays;
import java.util.ArrayList;

public class SubArrays {
	public static void main(String[] args) {
		int[] input = {2,5};
		ArrayList<ArrayList<Integer>> output = retSubarrays(input);
		System.out.println(output);
	}
	
	public static ArrayList<ArrayList<Integer>> retSubarrays(int[] input){
		return helper(input,new ArrayList<>(),0);
	}
	
	private static ArrayList<ArrayList<Integer>> helper(int[] input, ArrayList<Integer> output, int i) {
		if(i == input.length) {
			ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
			temp.add(output);
			return temp;
		}
		ArrayList<ArrayList<Integer>> left = helper(input, output, i+1);
		
		ArrayList<Integer> output2 = new ArrayList<>();
		output2.addAll(output);
		output2.add(input[i]);
		ArrayList<ArrayList<Integer>> right = helper(input,output2,i+1);
		
		left.addAll(right);
		return left;
	}

}
