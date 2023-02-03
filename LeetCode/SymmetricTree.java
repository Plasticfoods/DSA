package LeetCode;
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
	
	/*
	 * https://leetcode.com/problems/symmetric-tree/
	 * 
	 * Recursive
	public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return helper(root.left,root.right);
    }
    
    
    private boolean helper(TreeNode p, TreeNode q) {
        if(p==null && q==null) 
            return true;
        if(p==null || q==null)
            return false;
        if(p.val != q.val)
            return false;
        
        boolean res = helper(p.left,q.right) && helper(p.right,q.left);
        return res;
    }*/
}
