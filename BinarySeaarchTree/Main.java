package BinarySeaarchTree;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BinaryTreeNode<Integer> createTree(){
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(10);
        BinaryTreeNode<Integer> temp5 = new BinaryTreeNode<Integer>(5);
        BinaryTreeNode<Integer> temp4 = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> temp6 = new BinaryTreeNode<Integer>(6);
        BinaryTreeNode<Integer> temp12 = new BinaryTreeNode<Integer>(12);
        BinaryTreeNode<Integer> temp14 = new BinaryTreeNode<Integer>(14);

        root.left = temp5;  root.right = temp12;  temp5.left = temp4;  temp5.right = temp6;  temp12.right = temp14;
        return root;
    }
    /*                             10
                                  /  \
                                 5    12
                                / \    \
                               4   6    14
    */

    public static void main(String[] args) {
        //demo tree
        BinaryTreeNode<Integer> root = createTree();

        //build binary tree from sorted array
        //int arr[] = {1,2,3,4,5,6,7,8};
        //BinaryTreeNode<Integer> root = SortedArray.buildTree(arr,0, arr.length-1);

        //isBST
        System.out.println(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        ReplaceData.fun(root);
        printLevelWise(root);

    }

    public static void printLevelWise(BinaryTreeNode<Integer> root){
        if(root==null)
            return;

        Queue<BinaryTreeNode<Integer>> q = new LinkedList<BinaryTreeNode<Integer>>();
        q.add(root);

        while(q.size()>0){
            BinaryTreeNode<Integer> front = q.poll();
            String output = front.data + ":";

            if(front.left==null && front.right==null){
                output += "L:-1,R:-1";
                continue;
            }

            if(front.left==null)
                output += "L:-1,";
            else{
                output += "L:" + front.left.data + ",";
                q.add(front.left);
            }

            if(front.right==null)
                output += "R:-1";
            else{
                output += "R:" + front.right.data;
                q.add(front.right);
            }

            System.out.println(output);
        }
    }

    public static boolean isBST(BinaryTreeNode<Integer> root, int min, int max){
        if(root==null)
            return true;

        if(root.data<min || root.data>max)
            return false;

        if(isBST(root.left, min, root.data-1)==false || isBST(root.right, root.data, max)==false)
            return false;

        return true;
    }

    public static Pair isBST(BinaryTreeNode<Integer> root){
        if(root==null)
            return new Pair(true,  Integer.MAX_VALUE, Integer.MIN_VALUE);

        Pair leftOutput = isBST(root.left);
        Pair rightOutput = isBST(root.right);

        Pair output = new Pair();
        if(leftOutput.isBST==false || rightOutput.isBST==false) {
            output.isBST = false;
            return output;
        }
        if(leftOutput.max>=root.data){
            output.isBST = false;
            return output;
        }
        if(rightOutput.min<root.data){
            output.isBST = false;
            return output;
        }

        output.max = Math.max(root.data, Math.max(leftOutput.max, rightOutput.max));
        output.min = Math.min(root.data, Math.min(leftOutput.min, rightOutput.min));
        return output;
    }

}

class Pair {
    boolean isBST;
    int max;
    int min;

    Pair(boolean var, int a, int b){
        isBST = var;
        min = a;
        max = b;
    }

    Pair(){
        isBST = true;
    }
}
