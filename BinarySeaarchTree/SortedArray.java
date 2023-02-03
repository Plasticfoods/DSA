package BinarySeaarchTree;

public class SortedArray {
    static BinaryTreeNode<Integer> buildTree(int[] arr, int s, int e){
        if(arr.length==0)
            return null;

        int m = s + (e-s)/2;
        if(s>m || m>e)
            return null;

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[m]);
        root.left = buildTree(arr, s, m-1);
        root.right = buildTree(arr, m+1, e);

        return root;
    }
}
