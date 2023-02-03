package DP;

public class ZeroOneKnapsack {
	
	public static int knapsack(int n, int[] weight, int[] values, int capacity) {
		int[][] dp = new int[n+1][capacity+1];
		for(int i=0 ; i<=n ; i++) {
			dp[i][0] = 0;
		}
		for(int i=0 ; i<=capacity ; i++) {
			dp[0][i] = 0;
		}
		
		for(int i=1 ; i<=n ; i++) {
			for(int j=1 ; j<=capacity ; j++) {
				int op1=0, op2=0;
				op1 = dp[i-1][j];
				if(weight[i-1] <= j) {
					op2 = values[i-1] + dp[i-1][j-weight[i-1]];
				}
				dp[i][j] = Math.max(op1, op2);
			}
		}
		return dp[n][capacity];
	}
}
