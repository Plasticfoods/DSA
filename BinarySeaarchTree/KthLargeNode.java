package BinarySeaarchTree;
import java.util.Queue;
import java.util.LinkedList;

public class KthLargeNode {
	
	public int kthSmallest(TreeNode root, int k) {
        Queue<Integer> q = new LinkedList<>();
        
        traverseTree(root, q);
        
        int kthElement = -1;
        while(k != 0) {
        	kthElement = q.poll();
        	k--;
        }
        
        return kthElement;
    }

	private void traverseTree(TreeNode root, Queue<Integer> q) {
		if(root == null) {
			return;
		}
		
		traverseTree(root.left, q);
		q.add(root.val);
		traverseTree(root.right, q);
	}
	
	
}
