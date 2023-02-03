package BinaryTree;

public class DoublyList {
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
        doublyList(root);
        BinaryTreeNode<Integer> ptr = head;
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr = ptr.right;
        }
    }

    // doubly list as inorder
    static BinaryTreeNode<Integer> previous = null;
    static BinaryTreeNode<Integer> head = null;
    public static void doublyList(BinaryTreeNode<Integer> root){
        if(root==null)
            return ;

        doublyList(root.left);
        if(head==null){
            head = root;
            previous = root;
        }
        else{
            previous.right = root;
            root.left = previous;
            previous = root;
        }

        doublyList(root.right);
    }


}
