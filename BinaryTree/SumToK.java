package BinaryTree;
import Queue.QueueEmptyException;

import static BinaryTree.BtUse1.printTree;
import static BinaryTree.BtUse1.takeInput;

import java.util.ArrayList;

public class SumToK {
    public static void main(String[] args) throws QueueEmptyException {
        BinaryTreeNode<Integer> root = takeInput();
        System.out.println();
        sum2K(root, 23);
    }

    public static void sum2K(BinaryTreeNode<Integer> root, int k) {
        //Your code goes here
        if(root==null)
            return;
        helper(root, new ArrayList<Integer>(), k);
    }

    public static void helper(BinaryTreeNode<Integer> root, ArrayList<Integer> output, int k){
        if(root==null)
            return;

        output.add(root.data);
        if(root.left==null && root.right==null){
            if(root.data==k) {
                print(output);
            }
            return;
        }

        if(root.left!=null) {
            helper(root.left, output, k - root.data);
            output.remove(output.size() - 1);
        }

        if(root.right!=null) {
            helper(root.right, output, k - root.data);
            output.remove(output.size() - 1);
        }
    }

    private static void print(ArrayList<Integer> output){
        for(int i=0 ; i<output.size() ; i++){
            System.out.print(output.get(i)+" ");
        }
        System.out.println();
    }

    static BinaryTreeNode<Integer> demoTree(){
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> temp1 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> temp2 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> temp3 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> temp4 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> temp5 = new BinaryTreeNode<>(6);

        root.left = temp1;  root.right = temp2;  temp1.left = temp3;  temp1.right =temp4;  temp2.right = temp5;
        return root;
    }
}
