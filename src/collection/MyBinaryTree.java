package collection;

/**
 * Class to represent a binary tree structure
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 */
public class MyBinaryTree {
    
    public MyBinaryTreeNode root;
    public String preorderStr = "", inorderStr = "", postorderStr = "";
    
    /**
     * Gets the size of the binary tree
     * @return the size of the tree
     */
    public int size(){
        return sizeHelper(root);
    }
    
    /**
     * Gets the height of the binary tree
     * @return the height of the tree
     */
    public int height(){
        return heightHelper(root, -1);
    }
    
    /**
     * Recursive method to obtain the size of the tree
     * @param rt the node for each recursive call
     * @return an integer value
     */
    private int sizeHelper(MyBinaryTreeNode rt){
        return rt == null ? 0 : sizeHelper(rt.left) + sizeHelper(rt.right) + 1;
    }
    
    /**
     * Recursive method to obtain the height of the tree
     * @param rt the node for each recursive call
     * @param ht an integer value to keep track of the height
     * @return an integer value
     */
    private int heightHelper(MyBinaryTreeNode rt, int ht){
        return rt == null ? ht : Math.max(heightHelper(rt.left, ht+1), heightHelper(rt.right, ht+1));
    }
    
    /**
     * Clears the binary tree
     */
    public void clear(){
        root = null;
        preorderStr = "";
        inorderStr = "";
        postorderStr = "";
    }
    
    /**
     * Checks whether the binary tree is empty
     * @return true if the tree is empty, false if it is not
     */
    public boolean isEmpty(){
        return root == null;
    }
    
    /**
     * Method to perform a preorder traversal of the binary tree
     */
    public void preorderTraversal(){
        preorderHelper(root);   
    }
    
    /**
     * Recursive method to assist in the preorder traversal of the tree
     * @param rt the node of each recursive call
     */
    private void preorderHelper(MyBinaryTreeNode rt){
        if(rt == null) return;
        System.out.print("\t" + rt.data);
        preorderHelper(rt.left);
        preorderHelper(rt.right);
    }
    
    /**
     * Method to perform an inorder traversal of the binary tree
     */
    public void postorderTraversal(){
        postorderHelper(root);   
    }
    
    /**
     * Recursive method to assist in the inorder traversal of the tree
     * @param rt the node of each recursive call
     */
    private void postorderHelper(MyBinaryTreeNode rt){
        if(rt == null) return;
        postorderHelper(rt.left);
        postorderHelper(rt.right);
        System.out.print("\t" + rt.data);
    }
    
    /**
     * Method to perform a postorder traversal of the binary tree
     */
    public void inorderTraversal(){
        inorderHelper(root);  
    }
    
    /**
     * Recursive method to assist in the postorder traversal of the tree
     * @param rt the node of each recursive call
     */
    private void inorderHelper(MyBinaryTreeNode rt){
        if(rt == null) return;
        inorderHelper(rt.left);
        System.out.print("\t" + rt.data);
        inorderHelper(rt.right);
    }
}
