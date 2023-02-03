package Graph;
import java.util.Scanner;

public class PrimsAlgo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();

		/* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
        int[][] matrix = new int[v][v];
		for(int i=0 ; i<e ; i++) {
			int fv = sc.nextInt();
			int sv = sc.nextInt();
			int weight = sc.nextInt();
			matrix[fv][sv] = weight;
			matrix[sv][fv] = weight;
		}
		
		primsAlgo(matrix);
		sc.close();
	}
    
    
    public static void primsAlgo(int[][] matrix) {
		int n = matrix.length; 
		//n=number of vertices
		int[] weight = new int[n];
		weight[0] = 0;
		for(int i=1 ; i<n ; i++) {
			weight[i] = Integer.MAX_VALUE;
		}
		int[] parent = new int[n];
		parent[0] = -1;
		boolean[] visited = new boolean[n];
		
		int count = 0;
		//count = number of edges for output
		while(count != n-1) {
			int minVertex = helper(weight,visited);
			visited[minVertex] = true;
			for(int i=0 ; i<n ; i++) {
				if(matrix[minVertex][i]!=0 && !visited[i]) {
					if(matrix[minVertex][i] < weight[i]) {
						weight[i] = matrix[minVertex][i];
						parent[i] = minVertex;
					}
				}
			}
			count++;
		}
		
		for(int i=1 ; i<n ; i++) {
            if(parent[i]<i)
				System.out.println(parent[i]+" "+i+" "+weight[i]);
            else
                System.out.println(i+" "+parent[i]+" "+weight[i]);
		}
	}
    
    //returns minimum weighted vertex among unvisited vertices
	private static int helper(int[] weight, boolean[] visited) {
		int minIndex = -1;
		for(int i=0 ; i<weight.length ; i++) {
			if(!visited[i]) {
				if(minIndex == -1)
					minIndex = i;
				else if(weight[i] < weight[minIndex])
					minIndex = i;
			}
		}
		return minIndex;
	}

}