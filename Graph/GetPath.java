package Graph;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;

public class GetPath {
	public static void main(String[] args)  throws NumberFormatException, IOException { 
        int v,e;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of vertices: ");
		v = sc.nextInt();
		System.out.println("Enter number of edges: ");
		e = sc.nextInt();
		
		int[][] edges = new int[v][v];
		for(int i=0 ; i<e ; i++) {
			int firstVertex = sc.nextInt();
			int secondVertex = sc.nextInt();
			edges[firstVertex][secondVertex] = 1;
			edges[secondVertex][firstVertex] = 1;
		}
		//System.out.println("Enter starting and ending vertex: ");
		int v1 = sc.nextInt();
		int v2 = sc.nextInt();
        if(v1>=v || v2>=v)
            return;
		boolean[] visited = new boolean[v];
		ArrayList<Integer> output = getPathUsingBfs(edges,visited,v1,v2);
		if(output!=null){
            for(int i=0 ; i<output.size() ; i++){
                System.out.print(output.get(i)+" ");
            }
        }
	}
    
    
    private static ArrayList<Integer> getPathUsingBfs(int[][] edges, boolean[] visited, int v1, int v2) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v1);
		HashMap<Integer,Integer> map = new HashMap<>();//stores vertex and its parent
		map.put(v1,-1);
		visited[v1] = true;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			if(edges[curr][v2] == 1) {
				map.put(v2,curr);
				break;
			}
			for(int i=0 ; i<edges.length ; i++) {
				if(edges[curr][i]==1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
					map.put(i,curr);
				}
			}
		}
		
		if(!map.containsKey(v2))
			return null;
		ArrayList<Integer> output = new ArrayList<>();
		output.add(v2);
		int parent = v2;
		while(map.get(parent) != -1) {
			parent = map.get(parent);
			output.add(parent);
		}
		return output;
	}
    
    //get path using dfs
    public static ArrayList<Integer> getPathDFS(int[][] edges,boolean[] visited,int V1,int V2){
        if(V1==V2)
        {
            ArrayList<Integer> ans=new ArrayList<>();
            visited[V1]=true;
            ans.add(V1);
            return ans;
        }
        visited[V1]=true;
        for(int i=0;i<edges.length;i++)
        {
            if(edges[V1][i]==1 && !visited[i])
            { 
                ArrayList<Integer> arr=getPathDFS(edges,visited,i,V2); 
                if(arr!=null)
                {
                    arr.add(V1);

                    return arr;
                }
            }
        }
        return null;
    }
}
