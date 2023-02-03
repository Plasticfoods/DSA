package Backtracking;

public class RateInAMaze {
	public static boolean ratInAMaze(int maze[][]){
		int n = maze.length;
        boolean[][] visited = new boolean[n][n];
        return helper(maze,0,0,n,visited);
	}
    
	
    private static boolean helper(int[][] maze, int i, int j, int n, boolean[][] visited) {
        if(i<0 || i>=n || j<0 || j>=n || maze[i][j]==0)
            return false;
        if(visited[i][j])
            return false;
		if(i==n-1 && j==n-1)
            return true;
        
        visited[i][j] = true;
        boolean a,b,c,d;
        a = helper(maze,i+1,j,n,visited);
        b = helper(maze,i,j+1,n,visited);
        c = helper(maze,i-1,j,n,visited);
        d = helper(maze,i,j-1,n,visited);
        
        if(a||b||c||d)
            return true;
        visited[i][j] = false;
        return false;
    }
}
