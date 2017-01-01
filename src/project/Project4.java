package project;

import collection.MyBinaryTreeNode;
import collection.MyDeque;
import collection.MyExpressionTree;
import collection.MyStack;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * CLASSES FOR PROJECT 3, LAB 6, 7, 9, AND FOR SORTEDSLLIST DO NOT WORK AS A RESULT OF MODIFICATIONS NECESSARY FOR PROJECT 4
 * Class to run the expression tree program for COSC 241 Project 4.
 * This program handles multiple digit integers, see the buildExpressionTree method.
 * Note: The WordFilesIO and ExpressionRegulators classes of the project collection are a part of this project.
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 */
public class Project4 {
    
    private static final String fpath = "../COSC241_P4_Input.txt";
    private static MyExpressionTree exTree = new MyExpressionTree();
    private static List<String> infList;
    private static final MyDeque q = new MyDeque();
    private static final MyStack st = new MyStack();
    private static int result;
    
    /**
     * Test method for the project. Handles file input and output, as well as 
     * running tests on each expression in the input file. 
     */
    public static void test(){
        
        result=0;
        File out = new File("../COSC241_P4_Output_jatripp0.txt");
        try {
            //Stores each line of the file in a list.
            infList = WordFilesIO.readFile(fpath).stream().filter((s) -> !s.isEmpty()).collect(Collectors.toList());
            //If the output file does not currently exist, create it.
            if(!out.exists()){
                out.createNewFile();
            }
            try (PrintWriter writer = new PrintWriter(out)) {
                for(String s : infList){
                    String root = s.trim().replaceAll(" ", "").replaceAll("\\[", "(").replaceAll("\\]", ")");
                    writer.println("Original Infix:\t" + root);
                    //Determines whether the given expression is valid
                    if(!ExpressionRegulators.allPMatched(root) || !ExpressionRegulators.allValid(root) || !ExpressionRegulators.isValidOrder(root)){
                        writer.println("Invalid Expression");
                        writer.println();
                    } else {
                        buildExpressionTree(root);
                        //Performs traversals on the tree
                        exTree.preorderTraversal();
                        writer.println("Preorder: " + exTree.preorderStr);
                        exTree.inorderTraversal();
                        writer.println("Inorder: " + exTree.inorderStr);
                        exTree.postorderTraversal();
                        writer.println("Postorder: " + exTree.postorderStr);
                        //Evaluates the tree and outputs the result
                        result = exTree.evaluate();
                        writer.println("Result: " + result);
                        writer.println();
                        //Clears the tree for the next expression
                        exTree.clear();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.toString());
            System.exit(0);
        }
    }
    
    /**
     * Creates an expression tree from a given infix expression
     * using stack and deque operations.
     * @param s the expression used to create the expression tree
     */
    public static void buildExpressionTree(String s){
        MyBinaryTreeNode root = new MyBinaryTreeNode(null);
        Scanner scan = new Scanner(s).useDelimiter("");
        while(scan.hasNext()){
            //Processes integer numbers in the expression
            if(scan.hasNextInt()){
                String i = scan.nextInt() + "";
                while(scan.hasNextInt()){
                    i += scan.nextInt();
                }
                q.insertBack(new MyBinaryTreeNode(Integer.parseInt(i)));
                continue;
            }
            /*
            //Processes float numbers in the expression
            else if(scan.hasNextFloat()){
                q.insertBack(new MyBinaryTreeNode(scan.nextFloat()));
                continue;
            }
            //Processes double numbers in the expression
            else if(scan.hasNextDouble()){
                q.insertBack(new MyBinaryTreeNode(scan.nextDouble()));
                continue;
            }
            */
            //Gets the next token of the scanner which will be either an operator or parentheses
            String token = scan.next();
            switch(token){
                case "(":
                    st.push(new MyBinaryTreeNode(token));
                    break;
                case ")":
                    while(st.top != null && !st.top.data.data.equals("(")){
                        root = st.pop();
                        root.right = q.removeBack();
                        root.left = q.removeBack();
                        q.insertBack(root);
                    }
                    if(st.top != null){
                        st.pop();
                    }
                    break;
                case "+":
                    if(st.top != null && !st.top.data.data.equals("(")){
                        root = st.pop();
                        root.right = q.removeBack();
                        root.left = q.removeBack();
                        q.insertBack(root);
                    }
                    st.push(new MyBinaryTreeNode(token));
                    break;
                case "-":
                    if(st.top != null && !st.top.data.data.equals("(")){
                        root = st.pop();
                        root.right = q.removeBack();
                        root.left = q.removeBack();
                        q.insertBack(root);
                    }
                    st.push(new MyBinaryTreeNode(token));
                    break;
                case "*":
                    if(st.top != null){
                        if(st.top.data.data.equals("+") || st.top.data.data.equals("-")){
                            st.push(new MyBinaryTreeNode(token));
                            break;
                        } else {
                            if(st.top != null && !st.top.data.data.equals("(")){
                                root = st.pop();
                                root.right = q.removeBack();
                                root.left = q.removeBack();
                                q.insertBack(root);
                            }
                            st.push(new MyBinaryTreeNode(token));
                        }
                    } else {
                        st.push(new MyBinaryTreeNode(token));
                    }
                    break;
                case "/":
                    if(st.top != null){
                        if(st.top.data.data.equals("+") || st.top.data.data.equals("-")){
                            st.push(new MyBinaryTreeNode(token));
                            break;
                        } else {
                            if(st.top != null && !st.top.data.data.equals("(")){
                                root = st.pop();
                                root.right = q.removeBack();
                                root.left = q.removeBack();
                                q.insertBack(root);
                            }
                            st.push(new MyBinaryTreeNode(token));
                        }
                    } else {
                        st.push(new MyBinaryTreeNode(token));
                    }
                    break;
                case "%":
                    if(st.top != null){
                        if(st.top.data.data.equals("+") || st.top.data.data.equals("-")){
                            st.push(new MyBinaryTreeNode(token));
                            break;
                        } else {
                            if(st.top != null && !st.top.data.data.equals("(")){
                                root = st.pop();
                                root.right = q.removeBack();
                                root.left = q.removeBack();
                                q.insertBack(root);
                            }
                            st.push(new MyBinaryTreeNode(token));
                        }
                    } else {
                        st.push(new MyBinaryTreeNode(token));
                    }
                    break;
            }
        }
        while(st.top != null){
            root = st.pop();
            root.right = q.removeBack();
            root.left = q.removeBack();
            q.insertBack(root);
        }
        //Sets the root of the expression tree to the remaining node on the deque
        exTree.root = root;
    }
}
