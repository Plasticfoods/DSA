package BinaryTree;
import Queue.QueueEmptyException;
// nodes at k distance from target node

public class AtKdistance {
    public static void main(String[] args) throws QueueEmptyException {
        BinaryTreeNode<Integer> root = BtUse1.takeInput();
        BtUse1.printLevelWise(root);
        BinaryTreeNode<Integer> target = root.left;
        //printDownNodes(root.left, 2);
        countDistance(root, target, 1);
    }

    static int countDistance(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> target, int k){
        if(root==null)
            return -1;

        if(root==target){
            printDownNodes(root, k);
            return 0;
        }

        int dleft = countDistance(root.left, target, k);
        if(dleft!=-1)
        {
            if(dleft+1==k)
                System.out.print(root.data+" ");

            else
                printDownNodes(root.right, k-dleft-2);

            return 1+dleft;
        }

        int dright = countDistance(root.right, target, k);
        if(dright!=-1)
        {
            if(dright+1==k)
                System.out.println(root.data);

            else
                printDownNodes(root.left, k-dright-2);

            return 1+dright;
        }

        return -1;
    }

    static void printDownNodes(BinaryTreeNode<Integer> root, int k){
        if(root==null || k<0)
            return;

        if(k==0){
            System.out.println(root.data);
            return;
        }

        printDownNodes(root.left, k-1);
        printDownNodes(root.right, k-1);
    }

}
