package BinaryTree;

public class BurnTree {
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
    /*
                          1
                        /   \
                       2     3
                      /  \
                     4    5

    */
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = createTree();
        BinaryTreeNode<Integer> target = root.left.right;
        System.out.println(target.data);
        System.out.println("Time to burn the tree = "+burnTime(root, target));

    }

    public static int burnTime(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> target){
        if(root==null)
            return -1;

        if(root.left==null && root.right==null){
            if(root==target)
                return 0;
            else
                return -1;
        }

        int time, height;
        time = burnTime(root.left, target);
        if(time!=-1)
        {
            height = getHeight(root);
            if(time>height)
                return time;
            else
                return time+height;
        }

        time = burnTime(root.right, target);
        if(time!=-1)
        {
            height = getHeight(root);
            if(time>height)
                return time;
            else
                return time+height;
        }

        return -1;
    }

    public static int getHeight(BinaryTreeNode<Integer> root){
        if(root==null)
            return 0;

        int left = getHeight(root.left);
        int right = getHeight(root.left);

        return Math.max(left, right) + 1;
    }
}
