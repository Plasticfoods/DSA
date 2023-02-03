package BinarySeaarchTree;

public class BinaryTreeNode<E> {
    public E data;
    public BinaryTreeNode<Integer> left;
    public BinaryTreeNode<Integer> right;

    public BinaryTreeNode(E data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
