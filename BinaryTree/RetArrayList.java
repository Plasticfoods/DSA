package BinaryTree;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class RetArrayList {
    public static BinaryTreeNode<Integer> createTree(){
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> temp2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> temp3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> temp4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> temp5 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> temp6 = new BinaryTreeNode<>(6);

        root.left = temp2;  root.right = temp3;  temp2.left = temp4;  temp2.right = temp5;  temp4.left = temp6;
        return root;
    }
    /*
                          1
                        /   \
                       2     3
                      /  \
                     4    5
                    /
                   6
    */
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = createTree();
        ArrayList<Integer> ans = fun(root);
        System.out.println(ans);
     }

     private static ArrayList<Integer> fun(BinaryTreeNode<Integer> root){
        if(root==null)
            return new ArrayList<>();

         ArrayList<Integer> arr = new ArrayList<>();
         arr.add(root.data);

         ArrayList<Integer> letfArr = fun(root.left);
         ArrayList<Integer> rightArr = fun(root.right);
         arr.addAll(letfArr);
         arr.addAll(rightArr);

         return arr;
     }
}
