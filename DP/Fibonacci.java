package DP;

public class Fibonacci {
	
    public static int fib(int n){
        int[] storage = new int[n+1];
        for(int i=0 ; i<storage.length ; i++){
            storage[i] = -1;
        }
        return fib(n,storage);
    }

    private static int fib(int n, int[] storage){
        if(n==1){
            storage[n] = 0;
            return storage[n];
        }
        if(n==2){
            storage[n] = 1;
            return storage[n];
        }
        if(storage[n] == -1)
            storage[n] = fib(n-1,storage) + fib(n-2,storage);

        return storage[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(45));
    }
    
}
