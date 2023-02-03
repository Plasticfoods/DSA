package DP;

public class ShortestUncommonSubsequence {
	
	public static void main(String[] args) {
		String s = "babbaa";
		String t = "babba";
		System.out.print(shortestSeq(s,t));
	}
	
	//brute-force approach
	static int shortestSeq(String s, String t) {
		return shortestSeq(s,t,"");
	}
	
	//subseq is a sub sequence of s
	static int shortestSeq(String s, String t, String subseq) {
		if(s.length() == 0) {
			if(isPresent(subseq,t))
				return -1;
			else
				return subseq.length();
		}		
		int left = shortestSeq(s.substring(1), t, subseq);
		int right = shortestSeq(s.substring(1), t, subseq + s.charAt(0));
		if(left==-1)
			return right;
		if(right==-1)
			return left;
		
		return Math.min(left, right);
	}

	private static boolean isPresent(String subseq, String t) {
		if(subseq.length() == 0)
			return true;
		for(int i=0 ; i<t.length() ; i++) {
			if(subseq.charAt(0) == t.charAt(i))
				subseq = subseq.substring(1);
			if(subseq.length()==0)
				return true;
		}
		return false;
	}

}
