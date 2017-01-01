package collection;

/**
 * A class to represent an expression tree
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 */
public class MyExpressionTree extends MyBinaryTree{
    
    /**
     * Default constructor for the expression tree
     */
    public MyExpressionTree(){
        root = null;
    }
    
    /**
     * Constructor for the expression tree given a root node
     * @param rt 
     */
    public MyExpressionTree(MyBinaryTreeNode rt){
        root = rt;
    }
    
    /**
     * Evaluates the expression tree
     * @return the result of evaluating the expression tree
     */
    public int evaluate(){
        if(root == null) return -1000000;
        return evaluateHelper(root);
    }
    
    /**
     * Recursive method to assist in the evaluation of the expression tree
     * @param rt the node for each recursive call
     * @return an integer value
     */
    private int evaluateHelper(MyBinaryTreeNode rt){
        if(rt.left == null){
            return Integer.parseInt(rt.data.toString());
        }
        switch(rt.data.toString()){
            case "+":
                return evaluateHelper(rt.left) + evaluateHelper(rt.right);
            case "-":
                return evaluateHelper(rt.left) - evaluateHelper(rt.right);
            case "/":
                return evaluateHelper(rt.left) / evaluateHelper(rt.right);
            case "*":
                return evaluateHelper(rt.left) * evaluateHelper(rt.right);
            case "%":
                return evaluateHelper(rt.left) % evaluateHelper(rt.right);
            default:
                return -1000000;
        }
    }
}
