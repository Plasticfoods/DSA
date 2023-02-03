package Tree;
import java.util.ArrayList;

public class TreeNode<E> {
    public E data;
    public ArrayList<TreeNode<E>> children;

    public TreeNode(E data){
        this.data = data;
        children = new ArrayList<>();
    }
}
