package DP;
/*Given an integer N, find and return the count of minimum numbers
required to represent N as a sum of squares.
That is, if N is 4, then we can represent it
as : {1^2 + 1^2 + 1^2 + 1^2} and {2^2}.
The output will be 1, as 1 is the minimum count of numbers
required to represent N as sum of squares.*/
public class MinNumOfSquares {
    public static int minSquare(int n){
        int dp[] = new int[n+1];
        for(int i=0 ; i<dp.length ; i++){
            dp[i] = -1;
        }
        return helper(n,dp);
    }

    private static int helper(int n, int[] dp) {
        if(n==0 || n==1 || n==2 || n==3){
            dp[n] = n;
            return dp[n];
        }
        if(dp[n] != -1)
            return dp[n];

        int ans = Integer.MAX_VALUE;
        for(int i=1 ; i*i<=n ; i++){
            ans = Math.min(ans, helper(n-i*i, dp));
        }

        dp[n] = ans + 1;
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(minSquare(15));
    }

    /*public static int minSquare(int n){
        if(n==0 || n==1 || n==2 || n==3)
            return n;

        int ans = Integer.MAX_VALUE;
        for(int i=1 ; i*i<=n ; i++){
            ans = Math.min(ans, minSquare(n-i*i));
        }

        return ans+1;
    }*/
}
