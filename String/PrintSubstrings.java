package String;
import java.util.ArrayList;

public class PrintSubstrings {
	
	public static void print(String s) {
		for(int i=0 ; i<s.length() ; i++) {
			for(int j=i+1 ; j<=s.length() ; j++) {
				System.out.println(s.substring(i,j));
			}
		}
	}
	
	public static void main(String[] args) {
		String s = "abc";
		//print(s);
		ArrayList<String> output = retSubstrings(s);
		System.out.println(output);
	}
	
	public static ArrayList<String> retSubstrings(String input) {
		return helper(input, "",0);
	}
	
	private static ArrayList<String> helper(String input, String output, int i) {
		if(i == input.length()) {
			ArrayList<String> temp = new ArrayList<>();
			temp.add(output);
			return temp;
		}
		
		ArrayList<String> left = helper(input,output,i+1);
		String output2 = output + input.charAt(i);
		ArrayList<String> right = helper(input,output2,i+1);
		left.addAll(right);
		return left;
	}
	
	
 
}
