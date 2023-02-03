package BinarySeaarchTree;

public class ReplaceData {
    public static void fun(BinaryTreeNode<Integer> root) {
        // Write your code here
        if(root==null)
            return;
        helper(root, root.data);
    }

    private static int helper(BinaryTreeNode<Integer> root, int sum){
        if(root==null)
            return 0;

        int temp=0;
        temp = helper(root.right, sum);
        if(temp>sum)
            sum = temp;
        if(root.data<sum){
            sum = sum + root.data;
            root.data = sum;
        }
        else if(root.data>sum)
            sum = root.data;
        temp = helper(root.left, sum);
        if(temp>sum)
            sum = temp;

        return sum;
    }
}
