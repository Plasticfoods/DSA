package DP;

public class LootHouses {
    public static int maxMoneyLooted(int[] house) {
        //Your code goes here
        if(house.length==0)
            return 0;
        if(house.length==1)
            return house[0];
        if(house.length==2)
            return Math.max(house[0],house[1]);

        int dp[] = new int[house.length];
        dp[0] = house[0];
        dp[1] = house[1];
        for(int i=2 ; i<house.length ; i++){
            dp[i] = house[i] + maxInRange(dp,i-2,0);
        }

        return dp[dp.length-1];
    }

    private static int maxInRange(int[] arr, int e, int s){
        if(s==e)
            return arr[e];
        int max = Integer.MIN_VALUE;
        for(int i=s ; i<=e ; i++){
            if(max<arr[i])
                max = arr[i];
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxMoneyLooted(new int[]{5,5,10,100,10,5}));
    }
}
