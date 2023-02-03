package Tree;
import java.util.Scanner;

import Queue.QueueEmptyException;
import Queue.QueueLL;

public class TreeUse1 {
    public static void main(String[] args) throws QueueEmptyException {
        Scanner sc = new Scanner(System.in);
        //TreeNode<Integer> root = createNode(sc);
        TreeNode<Integer> root = takeInput();
        //printTree(root);
        System.out.println();
        removeLeafNodes(root);
        printTree2(root);

        /*int n = numNodes(root);
        int h = getHeight(root);
        System.out.println("\nNumbers of node: "+n);
        System.out.println("height = "+h);*/
    }

    public static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root) {
        if(root==null)
            return null;
        if(root.children.size()==0) {
            return null;
        }

        for(int i=0 ; i<root.children.size() ; i++){
            TreeNode<Integer> temp = removeLeafNodes(root.children.get(i));
            if(temp==null)
                root.children.remove(i);
        }

        return root;
    }

    public static TreeNode<Integer> createNode(Scanner sc){
        //System.out.print("Enter data: ");
        TreeNode<Integer> root = new TreeNode<>(sc.nextInt());

        //System.out.print("Enter number of children: ");
        int childnum = sc.nextInt();
        for(int i=0 ; i<childnum ; i++){
            TreeNode<Integer> child = createNode(sc);
            root.children.add(child);
        }

        return root;
    }

    public static void printTree(TreeNode<Integer> root){
        String s = root.data+": ";
        for(int i=0 ; i<root.children.size() ; i++){
            s = s + root.children.get(i).data + " ";
        }
        System.out.println(s);

        for(int i=0 ; i<root.children.size() ; i++){
            printTree(root.children.get(i));
        }
    }

    public static TreeNode<Integer> takeInput() throws QueueEmptyException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter root data: ");
        TreeNode<Integer> root = new TreeNode<>(sc.nextInt());

        QueueLL<TreeNode<Integer>> q = new QueueLL<>();
        q.push(root);

        while(q.size()>0){
            TreeNode<Integer> frontNode = q.pop();
            System.out.print("\nEnter number of children of "+frontNode.data+": ");
            int numChildren = sc.nextInt();

            for(int i=0 ; i<numChildren ; i++){
                System.out.print("Enter "+(i+1)+" th data of "+frontNode.data+" node: ");
                TreeNode<Integer> newnode = new TreeNode<>(sc.nextInt());
                frontNode.children.add(newnode);
                q.push(newnode);
            }
        }

        return root;
    }

    public static void printTree2(TreeNode<Integer> root) throws QueueEmptyException {
        QueueLL<TreeNode<Integer>> q = new QueueLL<>();
        TreeNode<Integer> nullNode = new TreeNode<>(Integer.MIN_VALUE);
        q.push(root);
        q.push(nullNode);

        while(q.size()!=1){
            TreeNode<Integer> frontNode = q.pop();
            int numChildren = frontNode.children.size();
            String output = frontNode.data+": ";

            if(frontNode == nullNode){
                q.push(nullNode);
                System.out.println();
                continue;
            }

            for(int i=0 ; i<numChildren ; i++){
                output = output + frontNode.children.get(i).data + " ";
                q.push(frontNode.children.get(i));
            }

            System.out.print(output+"   ");
        }
    }

    public static int numNodes(TreeNode<Integer> root){
        if(root == null)
            return 0;

        int count = 1;
        for(int i=0 ; i<root.children.size() ; i++){
            count = count + numNodes(root.children.get(i));
        }

        return count;
    }

    public static int getHeight(TreeNode<Integer> root){
        if(root == null)
            return 0;

        int max=0;
        for(int i=0 ; i<root.children.size() ; i++){
            int temp = getHeight(root.children.get(i));
            if(temp>max)
                max = temp;
        }

        return max+1;
    }

}
