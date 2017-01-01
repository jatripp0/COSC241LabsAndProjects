package collection;

/**
 * Class to represent a binary tree node
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 */
public class MyBinaryTreeNode implements Comparable<MyBinaryTreeNode>{
    
    public Object data;
    public MyBinaryTreeNode left, right;
    
    /**
     * Constructor for a binary tree node. Left and right children default to null
     * @param d the data value of the node
     */
    public MyBinaryTreeNode(Object d){
        data = d;
        left = null;
        right = null;
    }
    
    /**
     * Constructor for a binary tree node.
     * @param d the data value of the node
     * @param l left child of the node
     * @param r right child of the node
     */
    public MyBinaryTreeNode(Object d, MyBinaryTreeNode l, MyBinaryTreeNode r){
        data = d;
        left = l;
        right = r;
    }
    
    /**
     * Creates a string representation of the binary tree node
     * @return the string representation
     */
    @Override
    public String toString(){
        return data.toString();
    }

    /**
     * Compares binary tree nodes
     * @param o the binary tree node to compare to 
     * @return an integer to indicate the result of the comparison
     */
    @Override
    public int compareTo(MyBinaryTreeNode o) {
        return ((Comparable)this.data).compareTo(o.data);
    }
}
