package Graph;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DisconnectedGraphs {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
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
        //returns all connected graphs
		ArrayList<ArrayList<Integer>> output = retConnectedGraphs(edges);
		for(int i=0 ; i<output.size() ; i++){
            for(int j=0 ; j<output.get(i).size() ; j++){
                System.out.print(output.get(i).get(j)+" ");
            }
            System.out.println();
        }
	}
    
	
    public static ArrayList<ArrayList<Integer>> retConnectedGraphs(int[][] edges){
		ArrayList<ArrayList<Integer>> output = new ArrayList<>();
		boolean[] visited = new boolean[edges.length];
		for(int i=0 ; i<edges.length ; i++) {
			if(!visited[i])
				output.add(helper(edges,visited,i));
		}
		return output;
	}
	
	private static ArrayList<Integer> helper(int[][] edges, boolean[] visited, int v){
		ArrayList<Integer> subarr = new ArrayList<>(); //1d array of connected graph
		subarr.add(v);
		visited[v] = true;
		for(int i=0 ; i<edges.length ; i++) {
			if(edges[v][i]==1 && !visited[i]) {
				ArrayList<Integer> temp = helper(edges,visited,i);
				subarr.addAll(temp);
			}
		}
		return subarr;
	}

}
