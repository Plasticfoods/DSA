package BinaryTree;

public class PrintAncestors {
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
        //BtUse1.printLevelWise(root);
        int target = 6;
        printAncestors(root, 6);
    }

    static boolean printAncestors(BinaryTreeNode<Integer> root, int target){
        if(root==null)
            return false;

        if(root.data==target)
            return true;

        System.out.print(root.data+" ");
        if(printAncestors(root.left, target) || printAncestors(root.right, target)){
            //System.out.print(root.data+" ");
            return true;
        }

        return false;
    }
}
