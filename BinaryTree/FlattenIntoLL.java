package BinaryTree;

public class FlattenIntoLL {
    public static BinaryTreeNode<Integer> createTree(){
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> temp2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> temp3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> temp4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> temp5 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> temp6 = new BinaryTreeNode<>(6);

        root.left = temp2;  root.right = temp3;  temp2.left = temp4;  temp2.right = temp5;  temp4.left = temp6;
        return root;
    }
    /*
                          1
                        /   \
                       2     3
                      /  \
                     4    5
                    /
                   6
    */
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = createTree();
        flatten(root);

        BinaryTreeNode<Integer> ptr = root;
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr = ptr.right;
        }
    }

    //singly linked list in preorder
    public static void flatten(BinaryTreeNode<Integer> root){
        if(root==null)
            return;

        flatten(root.left);
        BinaryTreeNode<Integer> temp = root.right;
        root.right = root.left;
        root.left = null;

        BinaryTreeNode<Integer> curr = root;
        while(curr.right!=null){
            curr = curr.right;
        }

        curr.right = temp;
        flatten(root.right);
    }
}
