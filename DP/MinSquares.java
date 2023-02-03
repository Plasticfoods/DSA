package DP;
//minimum number of squares to represent n

public class MinSquares {
	public static int minSquare(int n) {
		if(n==0 || n==1)
			return n;
		int[] dp = new int[n+1];
		//dp[i]: minimum number of squares to represent i
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i=2 ; i<=n ; i++) {
			int minAns = Integer.MAX_VALUE;
			for(int j=1 ; j*j<=i ; j++) {
				int currAns = dp[i-(j*j)];
				if(currAns < minAns)
					minAns = currAns;
			}
			dp[i] = 1+minAns;
		}
		
		return dp[n];
	}
	
	public static void main(String[] args) {
		System.out.println(minSquare(10));
	}
}
