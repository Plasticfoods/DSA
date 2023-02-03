package BinaryTree;
import java.util.Stack;

public class ZigzacOrder {
    public static BinaryTreeNode<Integer> createTree(){
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> temp2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> temp3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> temp4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> temp5 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> temp6 = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> temp7 = new BinaryTreeNode<>(7);
        BinaryTreeNode<Integer> temp8 = new BinaryTreeNode<>(8);
        BinaryTreeNode<Integer> temp9 = new BinaryTreeNode<>(9);

        root.left = temp2;  root.right = temp3;  temp2.left = temp4;  temp2.right = temp5;  temp4.left = temp6;  temp3.left = temp7;  temp3.right = temp8;  temp7.left = temp9;
        return root;
    }
    /*
                          1
                        /    \
                       2      3
                      / \    / \
                     4   5  7   8
                    /      /
                   6      9
    */
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = createTree();
        printZiczac(root);
    }

    public static void printZiczac(BinaryTreeNode<Integer> root){
        if(root==null)
            return;

        Stack<BinaryTreeNode<Integer>> curr = new Stack<>();
        Stack<BinaryTreeNode<Integer>> next = new Stack<>();
        boolean leftToRight = true;
        curr.push(root);

        while(curr.size()>0)
        {
            BinaryTreeNode<Integer> topNode = curr.pop();
            System.out.print(topNode.data+" ");
            if(leftToRight){
                if(topNode.left!=null)
                    next.push(topNode.left);
                if(topNode.right!=null)
                    next.push(topNode.right);
            }
            else{
                if(topNode.right!=null)
                    next.push(topNode.right);
                if(topNode.left!=null)
                    next.push(topNode.left);
            }

            if(curr.size()==0){
                Stack<BinaryTreeNode<Integer>> temp = curr;
                curr = next;
                next = temp;
                if(leftToRight)
                    leftToRight = false;
                else
                    leftToRight = true;
            }
        }

    }

    public static void printZiczac2(BinaryTreeNode<Integer> root){
        int height = getHeight(root);
        int flag=0;
        for(int i=1 ; i<=height ; i++){
            print(root, i, flag);
            System.out.println();
            if(flag==0)
                flag=1;
            else
                flag=0;
        }
    }

    public static void print(BinaryTreeNode<Integer> root, int level, int flag){
        if(root==null)
            return;

        if(level==1){
            System.out.print(root.data+" ");
            return;
        }

        if(flag==0){
            print(root.left, level-1, flag);
            print(root.right, level-1, flag);
        }
        else{
            print(root.right, level-1, flag);
            print(root.left, level-1, flag);
        }
    }

    public static int getHeight(BinaryTreeNode<Integer> root){
        if(root==null)
            return 0;

        int left = getHeight(root.left);
        int right = getHeight(root.left);

        return Math.max(left, right) + 1;
    }
}
