package DP;

public class SumOfSquares {
    public static int fun(int a, int b) {
        return helper(a,b,1);
    }

    private static int helper(int a, int b, int k){
        if(a == 0)
            return 1;
        if(a < 0)
            return 0;

        int ans = 0;
        for(int i=k ; (int)Math.pow(i,b)<=a ; i++){
            int aNext = a - (int)Math.pow(i,b);
            ans += helper(aNext , b , i+1);
        }
        return ans;
    }
}
