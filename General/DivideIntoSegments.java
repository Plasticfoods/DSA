import java.util.Arrays;

public class DivideIntoSegments {

	public static void main(String[] args) {
		System.out.println("Hello World");
		int[] data = {1,2,3,4,5,6,7,8,9,10};
		int m = 4;
		divideIntoSegments(data, m);
	}
	
	public static int[][] divideIntoSegments(int[] data, int m) {
        int n = data.length;
        if(data == null || m > n) return null;

        int[][] segments = null;
        boolean addPadding = false;
        if(n%m == 0) {
            segments = new int[n%m][m];
        }
        else {
            segments = new int[n%m+1][m];
            addPadding = true;
        }
        
        System.out.println("row = " + n%m + ", col = " + m);
        
        for(int i=0 ; i<n%m ; i++) {
            for(int j=0 ; j<m ; j++) {
                segments[i][j] = data[(n%m * i) + j];
            }
        }

        if(addPadding) {
            int rem = n - m * (n%m);
            int i = 0;
            while(i < rem) {
                int index = m*(n%m) + i;
                segments[n%m][i] = data[index];
                i++;
            }
            while(i < m) {
                segments[n%m][i] = -1;
            }
        } 

        for(int i=0 ; i<segments.length ; i++) {
            for(int j=0 ; j<segments[i].length ; j++) {
                System.out.print(segments[i][j] + " ");
            }           
            System.out.println();
        }
        return segments;
    }
}
