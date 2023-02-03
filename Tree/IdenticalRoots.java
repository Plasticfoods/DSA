package Tree;
import Queue.QueueEmptyException;

import static Tree.TreeUse1.printTree2;

public class IdenticalRoots {
    public static void main(String[] args) throws QueueEmptyException {
        //root1
        TreeNode<Integer> root = new TreeNode<>(5);
        TreeNode<Integer> rootchild1 = new TreeNode<>(1);
        TreeNode<Integer> rootchild2 = new TreeNode<>(2);
        TreeNode<Integer> rootchild3 = new TreeNode<>(3);

        root.children.add(rootchild1);  root.children.add(rootchild2);  root.children.add(rootchild3);
        TreeNode<Integer> temp1 = new TreeNode<>(10);
        TreeNode<Integer> temp2 = new TreeNode<>(11);
        TreeNode<Integer> temp3 = new TreeNode<>(15);

        rootchild1.children.add(temp1);  rootchild1.children.add(temp2);
        rootchild3.children.add(temp3);

        //root2
        TreeNode<Integer> root2 = new TreeNode<>(5);
        root2.children.add(rootchild1);  root2.children.add(rootchild2);  root2.children.add(rootchild3);

        printTree2(root2);
        System.out.println("\n"+checkIndentical(root, root2));
    }

    public static boolean checkIndentical(TreeNode<Integer> root1, TreeNode<Integer> root2){
        if(root1==null && root2==null)
            return true;

        if(root1.data!=root2.data)
            return false;

        if(root1.children.size()!=root2.children.size())
            return false;

        boolean ans = true;
        for(int i=0 ; i<root1.children.size() ; i++){
            ans = checkIndentical(root1.children.get(i), root2.children.get(i));
            if(ans == false)
                return ans;
        }

        return ans;
    }
}
