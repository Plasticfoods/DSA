package BinaryTree;
import java.util.Queue;
import java.util.LinkedList;

public class LevelOrderTraversal {

	public static void printLevelWise(BinaryTreeNode<Integer> root) {
        if(root==null)
            return;
        
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
        q.add(root);
        BinaryTreeNode<Integer> nullNode = new BinaryTreeNode<>(-1);
        q.add(nullNode);
        
        while(q.size()!=1){
            BinaryTreeNode<Integer> frontNode = q.poll();
            if(frontNode==nullNode){
                q.add(nullNode);
                System.out.println();
                continue;
            }
            
            System.out.print(frontNode.data+" ");
            if(frontNode.left!=null)
                q.add(frontNode.left);
            if(frontNode.right!=null)
                q.add(frontNode.right);
        }
	}
	
	
}
