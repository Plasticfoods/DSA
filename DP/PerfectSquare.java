class PerfectSquare {

    public int numSquares(int n) {
        // dp[i] = least number of perfect square numbers that sum to dp[i].
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        return helper(n, dp);
    }

    private int helper(int n, int[] dp) {
        if(dp[n] != 0) return dp[n];
        if(isPerfectSquare(n)) return 1;
        
        int min = Integer.MAX_VALUE;
        for(int i=1 ; i<=n/2 ; i++) {
            int curr = helper(i, dp) + helper(n-i, dp);
            min = Math.min(curr, min);
        }
        dp[n] = min;
        return dp[min];
    }

    private boolean isPerfectSquare(int n) {
        int a = (int)Math.sqrt(n);
        return (a*a == n);
    }

    public static void main(String[] args) {
        PerfectSquare obj = new PerfectSquare();
        System.out.println(obj.numSquares(2004));
    }
}