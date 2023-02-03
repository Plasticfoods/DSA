package Graph;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Bfs {
	public static void main(String[] args){
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
		
		traverse(edges);
		sc.close();
	}
    
    
    public static void traverse(int[][] edges) {
		boolean[] visited = new boolean[edges.length];
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i=0 ; i<edges.length ; i++) {
			if(visited[i])
				continue;
			
			q.add(i);
			while(!q.isEmpty()) {
				int curr = q.poll();
				System.out.print(curr+" ");
				visited[curr] = true;
				for(int j=0 ; j<edges.length ; j++) {
					if(edges[curr][j]==1 && !visited[j]){
						q.add(j);
                        visited[j] = true;
                    }
				}
			}
		}
		
	
	}
    
}
