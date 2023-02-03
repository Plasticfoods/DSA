package BinaryTree;
import java.util.ArrayDeque;

public class SymmetricTree {
	
	public static boolean isSymmetric(TreeNode root) {
		if(root == null)
			return true;
		TreeNode breakNode = new TreeNode(Integer.MIN_VALUE);
		ArrayDeque<TreeNode> q = new ArrayDeque<>();
		q.add(root);
		q.add(breakNode);
		ArrayDeque<TreeNode> deq = new ArrayDeque<>();
		
		while(!q.isEmpty()) {
			TreeNode curr = q.poll();
			if(curr != breakNode) {
				if(curr.left == null) {
					deq.addLast(breakNode);
				}
				else {
					q.add(curr.left);
					deq.addLast(curr.left);
				}
				
				if(curr.right == null) {
					deq.addLast(breakNode);
				}
				else {
					q.add(curr.right);
					deq.addLast(curr.right);
				}
				continue;
			}
			
			while(deq.size() > 0) {
				TreeNode front = deq.removeFirst();
				TreeNode last = deq.removeLast();
				if(front.val != last.val)
					return false;
			}
			
			if(q.size()>0) {
				q.add(breakNode);
			}
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode c2 = new TreeNode(2);
        TreeNode c3 = new TreeNode(2);
        root.left = c2;
        root.right = c3;
        
        System.out.println(isSymmetric(root));
        
    }
}










