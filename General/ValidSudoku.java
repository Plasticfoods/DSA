package General;
import java.util.HashSet;

public class ValidSudoku {
	
public boolean isValidSudoku(char[][] board) {
        
        for(int row=0 ; row<9 ; row++){
            HashSet<Character> set = new HashSet<>();
            for(int col=0 ; col<9 ; col++){
            	if(board[row][col] != '.') {
                	if(set.contains(board[row][col])) {
                		return false;
                	}
                	else
                		set.add(board[row][col]);
                }
            }
        }
        
        for(int col=0 ; col<9 ; col++){
            HashSet<Character> set = new HashSet<>();
            for(int row=0 ; row<9 ; row++){
            	if(board[row][col] != '.') {
                	if(set.contains(board[row][col])) {
                		return false;
                	}
                	else
                		set.add(board[row][col]);
                }
            }
        }
        
        
        for(int i=0 ; i<9 ; i=i+3){
            for(int j=0 ; j<9 ; j=j+3){
                
                HashSet<Character> set = new HashSet<>();
                for(int x=i ; x<i+3 ; x++){
                    for(int y=j ; y<j+3 ; y++){
                        if(board[x][y] != '.') {
                        	if(set.contains(board[x][y])) {
                        		return false;
                        	}
                        	else
                        		set.add(board[x][y]);
                        }
                    }
                }
                
            }
        }
        
        
        return true;
    }


	public static void main(String[] args) {
		
	}
	
}
