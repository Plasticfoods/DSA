package BinaryTree;

import Queue.QueueEmptyException;
import Queue.QueueLL;

import java.sql.SQLOutput;

public class LeftRightView {
    public static BinaryTreeNode<Integer> createTree(){
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> temp2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> temp3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> temp4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> temp5 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> temp6 = new BinaryTreeNode<>(6);

        root.left = temp2;  root.right = temp3;  temp2.left = temp4;  temp2.right = temp5;  temp4.right = temp6;
        return root;
    }
    /*
                          1
                        /   \
                       2     3
                      /  \
                     4    5
                      \
                       6
    */
    public static void main(String[] args) throws QueueEmptyException {
        BinaryTreeNode<Integer> root = createTree();
        //leftView(root, 1);
        leftView2(root);
        System.out.println();
        rightView(root, 1);
    }

    static int currLevel = 0;
    static void leftView(BinaryTreeNode<Integer> root, int level){
        if(root==null)
            return;

        if(currLevel<level){
            System.out.print(root.data+" ");
            currLevel = level;
        }

        leftView(root.left, level+1);
        leftView(root.right, level+1);
    }

    static void leftView2(BinaryTreeNode<Integer> root) throws QueueEmptyException {
        QueueLL<BinaryTreeNode<Integer>> q = new QueueLL<>();
        if(root!=null)
            q.push(root);

        while(q.size()>0){
            BinaryTreeNode<Integer> frontNode = q.pop();
            System.out.print(frontNode.data+" ");
            if(frontNode.left!=null)
                q.push(frontNode.left);
            else if(frontNode.right!=null)
                q.push(frontNode.right);
        }
    }

    static void rightView(BinaryTreeNode<Integer> root, int level){
        if(root==null)
            return;

        if(currLevel<level){
            System.out.print(root.data+" ");
            currLevel = level;
        }

        rightView(root.right, level+1);
        rightView(root.left, level+1);
    }
}
