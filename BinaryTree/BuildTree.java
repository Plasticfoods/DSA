package BinaryTree;

class BuildTree {

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        if(preOrder==null || inOrder==null) return null;

        return helper(preOrder, inOrder, 0, preOrder.length-1, 0, inOrder.length-1);
    }

    private TreeNode helper(int[] preOrder, int[] inOrder, int pS, int pE, int inS, int inE) {
        if(pS>pE || inS>inE) return null;

        int rootData = preOrder[pS];
        TreeNode root = new TreeNode(rootData);

        int rootIndex = -1;
        for(int i=inS ; i<=inE ; i++) {
            if(rootData == inOrder[i]) {
                rootIndex = i;
                break;
            }
        }

        int left_pS = pS + 1;
        int left_pE = pS + (rootIndex-inS);
        int left_inS = inS;
        int left_inE = rootIndex - 1;

        int right_pS = left_inE + 1;
        int right_pE = pE;
        int right_inS = rootIndex + 1;
        int right_inE = inE;

        root.left = helper(preOrder, inOrder, left_pS, left_pS, left_inS, left_inE);
        root.right = helper(preOrder, inOrder, right_pS, right_pE, right_inS, right_inE);

        return root;
    }
}



























//import static BinaryTree.BtUse1.printLevelWise;
//import static BinaryTree.BtUse1.printTree;
//
//public class BuildTree {
//
//    public static void main(String[] args)
//    {
//        int[] preOrder = {1,2,4,5,3,6};
//        int[] inOrder =  {4,2,5,1,6,3,7};
//        int[] postOrder = {4,5,2,6,7,3,1};
//
//        //BinaryTreeNode<Integer> root = helper(preOrder, inOrder, 0, preOrder.length-1, 0, inOrder.length-1);
//        BinaryTreeNode<Integer> root = buildTree2(postOrder, inOrder, 0, postOrder.length-1, 0, inOrder.length-1);
//        printTree(root);
//
//    }



//    public static BinaryTreeNode<Integer> helper(int[] p, int[] i, int ps, int pe, int is, int ie){
//        if(ps>pe || is>ie)
//            return null;
//
//        if(ps==pe){
//            BinaryTreeNode<Integer> root = new BinaryTreeNode<>(p[ps]); // error
//            root.left = null;
//            root.right = null;
//            return root;
//        }
//
//        int rootdata = p[ps];
//        int rootIndex=0;
//        for(int j=is ; j<=ie ; j++){
//            if(i[j]==rootdata){
//                rootIndex = j;
//                break;
//            }
//        }
//
//        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootdata);
//        int distance = rootIndex-is-1;
//
//        root.left = helper(p, i, ps+1, ps+1+distance, is, rootIndex-1);
//        root.right = helper(p, i, ps+1+distance+1, pe, rootIndex+1, ie); // error, error
//
//        return root;
//    }
//
//    public static BinaryTreeNode<Integer> buildTree(){
//        return null;
//    }

    // build tree from inorder, postorder
    // S = starting index, E = ending index
//    public static BinaryTreeNode<Integer> buildTree2(int[] p, int[] i, int pS, int pE, int iS, int iE){
//        if(pS>pE || iS>iE)
//            return null;
//
//        int rootData = p[pE];
//        int rootIndex=0;
//        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
//        for(int j=iS ; j<=iE ; j++){
//            if(i[j]==rootData) {
//                rootIndex = j;
//                break;
//            }
//        }
//
//        int right_pS = pE-(iE-rootIndex);
//        int right_pE = pE-1;
//        int right_iS = rootIndex+1;
//        int right_iE = iE;
//
//        int left_pS = pS;
//        int left_pE = right_pS-1;
//        int left_iS = iS;
//        int left_iE = rootIndex-1;
//
//        root.left = buildTree2(p, i, left_pS, left_pE, left_iS, left_iE);
//        root.right = buildTree2(p, i, right_pS, right_pE, right_iS, right_iE);
//
//        return root;
//    }





//}
