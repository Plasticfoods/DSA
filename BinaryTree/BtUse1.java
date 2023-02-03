package BinaryTree;
import java.util.Queue;
import java.util.LinkedList;
import Queue.QueueEmptyException;
import Queue.QueueLL;
import java.util.Scanner;

public class BtUse1 {
    public static void main(String[] args) throws QueueEmptyException {
        BinaryTreeNode<Integer> root = takeInput();
        System.out.println();
        printLevelWise(root);

        int n = countNodes(root);
        System.out.println("number of nodes: "+n);

        Pair diameter = findDiameter(root);
        System.out.println("diameter = "+diameter.diameter);
    }

    public static BinaryTreeNode<Integer> takeInput() throws QueueEmptyException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter root data: ");
        int rootdata = sc.nextInt();
        if(rootdata==-1)
            return null;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootdata);

        QueueLL<BinaryTreeNode<Integer>> q = new QueueLL<>();
        q.push(root);

        while(q.size()>0){
            BinaryTreeNode<Integer> frontNode = q.pop();
            int leftdata;
            System.out.print("Enter left child data of " + frontNode.data + ": ");
            leftdata = sc.nextInt();
            if(leftdata!=-1){
                BinaryTreeNode<Integer> leftchild = new BinaryTreeNode<>(leftdata);
                q.push(leftchild);
                frontNode.left = leftchild;
            }

            int rightdata;
            System.out.print("Enter right child data of "+ frontNode.data + ": ");
            rightdata = sc.nextInt();
            if(rightdata!=-1){
                BinaryTreeNode<Integer> rightchild = new BinaryTreeNode<>(rightdata);
                q.push(rightchild);
                frontNode.right = rightchild;
            }
        }

        return root;
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

    public static void printTree(BinaryTreeNode<Integer> root){
        if(root == null)
            return;

        String output = root.data + ": ";
        if(root.left!=null)
            output = output + "L" + root.left.data + ", ";
        if(root.right!=null)
            output = output + "R" + root.right.data;
        System.out.println(output);

        printTree(root.left);
        printTree(root.right);
    }

    public static int countNodes(BinaryTreeNode<Integer> root){
        if(root==null)
            return 0;

        int count = 1;
        if(root.left==null && root.right==null)
            return 1;

        count += countNodes(root.left);
        count += countNodes(root.right);

        return count;
    }

    public static Pair findDiameter(BinaryTreeNode<Integer> root){
        if(root==null)
            return new Pair(0,0);

        Pair leftOutput = findDiameter(root.left);
        Pair rightOutput = findDiameter(root.right);

        int option1 = leftOutput.height + rightOutput.height;
        int option2 = leftOutput.diameter;
        int option3 = rightOutput.diameter;

        int height = 1 + Math.max(leftOutput.height, rightOutput.height);
        int diameter = Math.max(option1, Math.max(option2, option3));

        Pair output = new Pair(height, diameter);
        return output;
    }

}



class Pair {
    int height;
    int diameter;

    Pair(int a, int b){
        height = a;
        diameter = b;
    }

    Pair(){}
}
