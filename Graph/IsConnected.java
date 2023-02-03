package Graph;
import java.io.IOException;
import java.util.Scanner;

public class IsConnected {
	public static void main(String[] args) throws NumberFormatException, IOException {
	       
        /* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
		 */
		int v,e;
		Scanner sc = new Scanner(System.in);
		//System.out.println("Enter number of vertices: ");
		v = sc.nextInt();
		//System.out.println("Enter number of edges: ");
		e = sc.nextInt();
		
		int[][] edges = new int[v][v];
		for(int i=0 ; i<e ; i++) {
			int firstVertex = sc.nextInt();
			int secondVertex = sc.nextInt();
			edges[firstVertex][secondVertex] = 1;
			edges[secondVertex][firstVertex] = 1;
		}

		System.out.println(isConnected(edges));
	}
    
    
    public static boolean isConnected(int[][] edges) {
		if(edges.length == 0)
			return true;
		boolean[] visited = new boolean[edges.length];
		helper(edges,visited,0);
		for(int i=0 ; i<visited.length ; i++) {
			if(!visited[i])
				return false;
		}
		return true;
	}
    
    
    private static void helper(int[][] edges, boolean[] visited, int v) {
		visited[v] = true;
		for(int i=0 ; i<edges.length ; i++) {
			if(edges[v][i]==1 && !visited[i])
				helper(edges,visited,i);
		}
	}
}
