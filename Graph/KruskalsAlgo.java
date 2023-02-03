package Graph;
import java.util.Scanner;
import java.util.Arrays;

public class KruskalsAlgo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v,e;
		//System.out.println("Enter number of vertices: ");
		v = sc.nextInt();
		//System.out.println("Enter number of edges: ");
		e = sc.nextInt();
		
		Edge[] input = new Edge[e];
		for(int i=0 ; i<e ; i++) {
			input[i] = new Edge();
			input[i].v1 = sc.nextInt();
			input[i].v2 = sc.nextInt();
			input[i].weight = sc.nextInt();
		}
		
		kruskal(input,v);
		sc.close();
	}
	
	public static void kruskal(Edge[] input, int n) {
		Edge[] output = new Edge[n-1];
		Arrays.sort(input);
		
		int[] parent = new int[n];
		for(int i=0 ; i<n ; i++) {
			parent[i] = i;
		}
		
		int i=0; //input array index
		int edgeCount = 0;
		while(edgeCount != n-1) {
			int v1 = input[i].v1;
			int v2 = input[i].v2;
			v1 = findParent(parent,v1);
			v2 = findParent(parent,v2);
			if(v1 != v2) {
				output[edgeCount++] = input[i];
				parent[v2] = v1;
			}
            i++;
		}
		
		for(i=0 ; i<output.length ; i++) {
			if(output[i].v1<output[i].v2)
                System.out.println(output[i].v1+" "+output[i].v2+" "+output[i].weight);
            else
                System.out.println(output[i].v2+" "+output[i].v1+" "+output[i].weight);
		}
	}
	
	
	private static int findParent(int[] parent, int v) {
		if(parent[v] == v)
			return v;
		return findParent(parent,parent[v]);
    }
}

class Edge implements Comparable<Edge> {
	int v1;
	int v2;
	int weight;
	

	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}
	
}
