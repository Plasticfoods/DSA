package Backtracking;

public class NQueen {
	static boolean isPossible;
	static int count;
	
	public static void nQueen(int n) {
		int[][] matrix = new int[n][n];
		traverseRow(matrix,0);
	}

	static void traverseRow(int[][] matrix, int row) {
		int n = matrix.length;
		if(row == n) {
			isPossible = true;
			printMatrix(matrix);
			count++;
		}
		
		for(int col=0 ; col<n ; col++) {
			if(isQueenSafe(matrix,row,col)) {
				matrix[row][col] = 1;
				traverseRow(matrix,row+1);
				matrix[row][col] = 0;
			}
		}
	}
	

	private static boolean isQueenSafe(int[][] matrix, int row, int col) {
		int n = matrix.length;
		for(int i=0 ; i<row ; i++) {
			if(matrix[i][col] == 1)
				return false;
		}
		
		int x,y;
		//left diagonal check
		x=row-1; y=col-1;
		while(x>=0 && y>=0 && x<n && y<n) {
			if(matrix[x][y] == 1)
				return false;
			x = x-1;
			y = y-1;
		}
		
		//right diagonal check
		x=row-1; y=col+1;
		while(x>=0 && y>=0 && x<n && y<n) {
			if(matrix[x][y] == 1)
				return false;
			x = x-1;
			y = y+1;
		}
		
		return true;
	}
	
	private static void printMatrix(int[][] matrix) {
		int n = matrix.length;		
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				if(matrix[i][j] == 1) {
					System.out.print("Q ");
				}
				else {
					System.out.print("- ");
				}
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
	}
	
	public static void main(String[] args) {
		int n = 5;
		nQueen(n);
		if(!isPossible) {
			System.out.println("Solutions not possible");
		}
		else {
			System.out.println("No of solutions: "+count);
		}
	}
	
	
	
	
	
	
}
