package DP;

public class ReduceN {
    public static int stepCounts(int n) {
        int[] steps = new int[n+1];
        for(int i=0 ; i<steps.length ; i++){
            steps[i] = -1;
        }

        return helper(n,steps);
    }

    private static int helper(int n, int[] steps) {
        if(n==1){
            steps[1] = 0;
            return steps[1];
        }
        if(n==2 || n==3){
            steps[n] = 1;
            return steps[n];
        }
        if(steps[n] != -1)
            return steps[n];

        int minSteps = Integer.MAX_VALUE;
        if(n%3 == 0)
            minSteps = Math.min(helper(n/3,steps), minSteps);
        if(n%2 == 0)
            minSteps = Math.min(helper(n/2,steps), minSteps);
        minSteps = Math.min(helper(n-1,steps), minSteps);

        steps[n] = minSteps+1;
        return steps[n];
    }

    private static int helper2(int n){
        int[] steps = new int[n+1];
        steps[0]=-1;
        steps[1]=0;
        for(int i=2;i<=n;i++){
            int a=Integer.MAX_VALUE,b=Integer.MAX_VALUE;
            if(i%3==0){
                a = steps[i/3];
            }
            if(i%2==0){
                b = steps[i/2];
            }
            steps[i]=1 + Math.min(a,Math.min(b,steps[i-1]));
        }
        return steps[n];
    }

    public static void main(String[] args) {
        System.out.println( helper2(1));
    }
}









