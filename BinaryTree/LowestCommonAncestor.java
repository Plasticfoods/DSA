package BinaryTree;

public class LowestCommonAncestor {
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
        int a=6, b=5;
        BinaryTreeNode<Integer> ans = lca(root, a, b);
        if(ans!=null)
            System.out.println(ans.data);
    }

    public static BinaryTreeNode<Integer> lca(BinaryTreeNode<Integer> root, int a, int b){
        if(root==null)
            return null;

        if(root.data==a || root.data==b)
            return root;

        BinaryTreeNode<Integer> left = lca(root.left, a, b);
        BinaryTreeNode<Integer> right = lca(root.right, a, b);

        if(left==null)
            return right;
        if(right==null)
            return left;

        return root;
    }
}
