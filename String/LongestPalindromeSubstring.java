package String;

public class LongestPalindromeSubstring {
	
	public static String longestPalindrome(String s) {
		if(s.length() <= 1)
			return s;
		int n = s.length();
		int left=0, right=0;
		String res = "";
		for(int i=0 ; i<n ; i++) {
			left = i-1;
			right = i+1;
			while(left>=0 && s.charAt(i)==s.charAt(left)) {
				left--;
			}
			while(right<n && s.charAt(i)==s.charAt(right)) {
				right++;
			}
			while(left>=0 && right<n && s.charAt(left)==s.charAt(right)) {
				left--;
				right++;
			}
			int currLen = right-left-1;
			if(res.length() < currLen) {
				res = s.substring(left+1,right);
			}
		}
		
		return res;
    }
	//from i we go to left,right to find how many range it has similar character
	//after finding the similar characters it will match the edge character if it has similar characters then its the answer
	//otherwise middle part of similar characters are answer
	
	public static void main(String[] args) {
        String s = "chha";
        System.out.println(longestPalindrome(s));
    }
}
