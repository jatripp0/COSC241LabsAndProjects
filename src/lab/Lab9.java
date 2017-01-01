package lab;

import collection.MyBinarySearchTree;
import java.util.Random;

/**
 * Executes the instructions for COSC 241 Lab 8
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 * @version 1.0
 */
public class Lab9 {
    
    public static MyBinarySearchTree BST = new MyBinarySearchTree();
    
    /**
     * Executes the instructions for COSC 241 Lab 9 and will be
     * run within the main method of the Main class.
     */
    public static void test(){
        System.out.println("COSC 241 Lab 9 - Johnathan Tripp");
        //Step 3b. Insert 100, 50, and 150 into the BinarySearchTree
        BST.insert(100);
        BST.insert(50);
        BST.insert(150);
        
        //Step 3c. Create a random number generator with system time as seed
        Random r = new Random(System.currentTimeMillis());
        
        //Step 3d. Generate 30 integers in the range [0,200] and insert them into the BinarySearchTree
        for(int i=0; i<30; ++i){
            BST.insert(r.nextInt(201));
        }
        
        //Step 3e. Print out the BinarySearchTree in inorder, preorder, and postorder
        System.out.print("Inorder Traversal:");
        BST.inorderTraversal();
        System.out.print("\nPreorder Traversal:");
        BST.preorderTraversal();
        System.out.print("\nPostorder Traversal:");
        BST.postorderTraversal();
        
        //Step 3f. Remove nodes from the BinarySearchTree
        BST.remove(BST.min());
        BST.remove(BST.max());
        BST.remove(50);
        BST.remove(100);
        BST.remove(150);
        
        //Step 3g. Print out the BinarySearchTree in inorder, preorder, and postorder
        System.out.println("\n\nTraversals the smallest and largest nodes, 50, 100, and 150 removed:");
        System.out.print("Inorder Traversal:");
        BST.inorderTraversal();
        System.out.print("\nPreorder Traversal:");
        BST.preorderTraversal();
        System.out.print("\nPostorder Traversal:");
        BST.postorderTraversal();
    }
}
