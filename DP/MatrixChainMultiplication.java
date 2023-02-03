package DP;
import java.util.Scanner;

public class MatrixChainMultiplication {
	public static int mcm(int[] p, int i, int j) {
		if(i == j)
			return 0;
		if(i+1 == j)
			return p[i-1]*p[i]*p[j];
		
		int ans = Integer.MAX_VALUE;
		//check for all possible parenthesis
		for(int k=i ; k<j ; k++) {
			int count = mcm(p,i,k) + mcm(p,k+1,j) + p[i-1]*p[k]*p[j];
			if(count<ans)
				ans = count;
		}
		return ans;
	}
	
	
	
	public static void main(String[] args) {
		int arr[] = new int[] {10, 20, 30, 40, 30};
		//input[i] : ith matrix is of arr[i-1]*arr[i]
        int n = arr.length;
        System.out.println(mcm(arr,1,n-1));
	}
	
	
	
	
	/*
	 * brute-force
	//i represents starting matrix and j represents numbers of matrices
	//if i=2, j=4, then it returns the value of A2*A3*A4
	public static int mcm(int[] input, int i, int j) {
		if(i == j)
			return 0;
		if(i+1 == j)
			return input[i-1]*input[i]*input[j];
		
		int ans = Integer.MAX_VALUE;
		//check for all possible parenthesis
		for(int k=i ; k<j ; k++) {
			int count = mcm(input,i,k) + mcm(input,k+1,j) + input[i-1]*input[k]*input[j];
			if(count<ans)
				ans = count;
		}
		return ans;
	}
	 */

}
