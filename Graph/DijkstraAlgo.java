package Graph;
import java.util.Scanner;

public class DijkstraAlgo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();

		/* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
        int[][] matrix = new int[V][V];
		for(int i=0 ; i<E ; i++) {
			int fv = sc.nextInt();
			int sv = sc.nextInt();
			int weight = sc.nextInt();
			matrix[fv][sv] = weight;
			matrix[sv][fv] = weight;
		}
		
		dijkstraAlgo(matrix);
		sc.close();
	}
    
    
    public static void dijkstraAlgo(int[][] matrix) {
		int V = matrix.length;
		boolean[] visited = new boolean[V];
		int[] distance = new int[V];
		//distance[i] =  distance from 0 to i vertex
		distance[0] = 0;
		for(int i=1 ; i<V ; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		int count = 0;
		//to run loop V-1 times
		while(count != V-1) {
			int minVertex = helper(distance,visited);
			//return minimum distance vertex among unvisited vertices
			visited[minVertex] = true;
			for(int i=0 ; i<V ; i++) {
				if(matrix[minVertex][i]!=0 && !visited[i]) {
					int currDistance = distance[minVertex]+matrix[minVertex][i];
					if(currDistance < distance[i])
						distance[i] = currDistance;
				}
			}
			count++;
		}
		
		for(int i=0 ; i<V ; i++) {
			System.out.println(i+" "+distance[i]);
		}
	}
	
	
	private static int helper(int[] distance, boolean[] visited) {
		int minIndex = -1;
		for(int i=0 ; i<distance.length ; i++) {
			if(!visited[i]) {
				if(minIndex == -1)
					minIndex = i;
				else if(distance[i] < distance[minIndex])
					minIndex = i;
			}
		}
		return minIndex;
	}
}

