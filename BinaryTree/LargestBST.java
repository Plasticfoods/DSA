package BinaryTree;

public class LargestBST {
    public static int largestBST(BinaryTreeNode<Integer> root){
        Bst ans = helper(root);
        return ans.size;
    }

    private static Bst helper(BinaryTreeNode<Integer> root){
        Bst output = new Bst();
        if(root==null){
            output.isbst = true;
            output.size = 0;
            output.min = Integer.MAX_VALUE;
            output.max = Integer.MIN_VALUE;
            return output;
        }
        Bst leftOutput = helper(root.left);
        Bst rightOutput = helper(root.right);

        if(leftOutput.max<root.data && rightOutput.min>=root.data)
            output.isbst = true;
        else
            output.isbst = false;

        if(output.isbst)
            output.size = leftOutput.size + rightOutput.size + 1;
        else
            output.size = Math.max(leftOutput.size, rightOutput.size);

        output.min = Math.min(root.data, Math.min(leftOutput.min, rightOutput.min));
        output.max = Math.max(root.data, Math.max(leftOutput.max, rightOutput.max));

        return output;
    }


}

class Bst {
    boolean isbst;
    int size;
    int min;
    int max;
}
