package BinaryTree;

public class DeleteNode {
	
	public static BinaryTreeNode<Integer> deleteNode(BinaryTreeNode<Integer> root, int key) {
		if(root == null)
			return null;
		if(root.data == key) {
			if(root.left==null && root.right==null)
				return null;
			else {
				if(root.right!=null) {
					root.data = root.right.data;
					root.right.data = key;
					root.right = deleteNode(root.right,key);
				}
				else {
					root.data = root.left.data;
					root.left.data = key;
					root.left = deleteNode(root.left,key);
				}
			}
		}
		else {
			root.left = deleteNode(root.left,key);
			root.right = deleteNode(root.right,key);
		}
		return root;
	}
	
	
    /*
                          1
                        /   \
                       2     3
                      /  \
                     4    5

    */
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = createTree();
        BtUse1.printLevelWise(root);
        System.out.println();
        int key = 9;
        root = deleteNode(root,key);
        BtUse1.printLevelWise(root);
    }
    
    public static BinaryTreeNode<Integer> createTree(){
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> temp2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> temp3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> temp4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> temp5 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> temp6 = new BinaryTreeNode<>(6);

        root.left = temp2;  root.right = temp3;  temp2.left = temp4;  temp2.right = temp5;  //temp4.left = temp6;
        return root;
    }
}
