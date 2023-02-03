package BinaryTree;

public class BinaryTreeNode<E> {
    public E data;
    public BinaryTreeNode<E> left;
    public BinaryTreeNode<E> right;

    public BinaryTreeNode(E data){
        this.data = data;
        left = null;
        right = null;
    }
}
