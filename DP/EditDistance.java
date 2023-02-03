package DP;

public class EditDistance {
    public static int editDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0 ; i<=m ; i++){
            for(int j=0 ; j<=n ; j++){
                dp[i][j] = -1;
            }
        }
        for(int i=0 ; i<=n ; i++){
            dp[0][i] = i;
        }
        for(int i=0 ; i<=m ; i++){
            dp[i][0] = i;
        }

        for(int i=1 ; i<=m ; i++){
            for(int j=1 ; j<=n ; j++){
                if(s1.charAt(m-i) == s2.charAt(n-j))
                    dp[i][j] = dp[i-1][j-1];
                else {
                    int op1 = dp[i][j-1];
                    int op2 = dp[i-1][j-1];
                    int op3 = dp[i-1][j];
                    dp[i][j] = 1 + Math.min(op1,Math.min(op2,op3));
                }
            }
        }
        return dp[m][n];
    }

    // Memorization
    private static int helper(String s1, String s2, int m, int n, int[][] dp) {
        if(dp[m][n] != -1)
            return dp[m][n];
        if(m == 0){
            dp[m][n] = n;
            return dp[m][n];
        }
        if(n == 0){
            dp[m][n] = m;
            return dp[m][n];
        }
        if(s1.charAt(m-1) == s2.charAt(n-1)){
            dp[m][n] = helper(s1,s2,m-1,n-1,dp);
            return dp[m][n];
        }
        int op1 = helper(s1,s2,m,n-1,dp);
        int op2 = helper(s1,s2,m-1,n,dp);
        int op3 = helper(s1,s2,m-1,n-1,dp);

        dp[m][n] = 1 + Math.min(op1, Math.min(op2,op3));
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(editDistance("bc","c"));
    }

}
