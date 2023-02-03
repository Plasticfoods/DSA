package DP;
import java.util.Scanner;

public class MinCostPath {
    public static int minCostPath(int[][] arr) {
        int m=arr.length, n=arr[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = arr[m-1][n-1];
        for(int i=n-2 ; i>=0 ; i--){
            dp[m-1][i] = arr[m-1][i] + dp[m-1][i+1];
        }
        for(int i=m-2 ; i>=0 ; i--){
            dp[i][n-1] = arr[i][n-1] + dp[i+1][n-1];
        }

        for(int i=m-2 ; i>=0 ; i--){
            for(int j=n-2 ; j>=0 ; j--){
                dp[i][j] = arr[i][j] + Math.min(dp[i][j+1], Math.min(dp[i+1][j+1],dp[i+1][j]) );
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[3][3];
        for(int i=0 ; i<3 ; i++){
            for(int j=0 ; j<3 ; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(minCostPath(arr));
    }
}
