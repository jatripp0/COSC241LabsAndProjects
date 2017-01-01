package project;

import java.io.IOException;
import java.util.List;
import collection.MyQueue;
import collection.MyStack;
import java.io.File;
import java.io.PrintWriter;
import java.util.stream.Collectors;

/**
 * Class to run the infix-to-postfix program for COSC 241 Project 3.
 * See the stackAndQueue method in this class for the code that
 * satisfies the bonus points requirements for COSC 241 Project 3.
 * Note: The WordFilesIO and ExpressionRegulators classes of the project collection are a part of this project.
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 * @version 1.0
 */
public class Project3 {

    private static final String fpath = "../COSC241_P3_Input.txt";
    private static List<String> infList;
    private static final MyQueue q = new MyQueue();
    private static final MyStack st = new MyStack();
    //A global variable that holds the result of calculating a postfix expression.
    private static int result;

    /**
     * Test method for the project. Handles file input and output, as well as 
     * running tests on each expression contained in the input file. 
     */
    public static void test() {
        
        result=0;
        File out = new File("../COSC241_P3_Output_jatripp0.txt");
        try {
            //Stores each line of the file in a list.
            infList = WordFilesIO.readFile(fpath);
            //If the output file does not currently exist, create it.
            if(!out.exists()){
                out.createNewFile();
            }
            try (PrintWriter writer = new PrintWriter(out)) {
                //Filters the list from the input file by removing blank lines.
                List<String> filtList = infList.stream().filter((s) -> !s.isEmpty()).collect(Collectors.toList());
                
                for (String s : filtList) {
                    //Removes intermediate whitespace, and replaces bracket characters with corresponding parentheses for easier calculation.
                    String temp = s.trim().replaceAll(" ", "").replaceAll("\\[", "(").replaceAll("\\]", ")");
                    //Prints the modified infix expression string.
                    writer.println("Infix Expression: " + temp);
                    /*
                    If an expression is recognized as invalid by the error testing methods,
                    the expression is labeled as such and no further operations will be done
                    on that expression.
                    */
                    if(!ExpressionRegulators.allPMatched(temp) || !ExpressionRegulators.allValid(temp) || !ExpressionRegulators.isValidOrder(temp)){
                        writer.println("Invalid Expression");
                        writer.println();
                    } else {
                        /*
                        If the current expression is valid, then the expression is converted
                        into postfix and evaluated. The postfix expression and its corresponding 
                        result is written to the output file.
                        */
                        //stackAndQueue(temp);
                        writer.println("Postfix Expression: " + q.toPostfixString()+ "\n");
                        //evalPostfix();
                        writer.println("Result: " + result);
                        writer.println();
                        //Resets the global result variable for further calculations.
                        result=0;
                    }
                    //Clears the queue containing a postfix expression for further calculations.
                    q.clear();
                }
            }
        } catch (IOException e) {
            System.out.println(e.toString());
            System.exit(0);
        }
    }
    
    /**
     * NOTE: This method satisfies the requirements for bonus points on Project 3
     * concerning multiple digit operands in the infix expression.
     * Receives an infix expression and handles stack and queue operations
     * to convert the expression to postfix. The resulting postfix expression
     * is held in the queue for evaluation.
     * @param s an infix expression 
     */
//    public static void stackAndQueue(String s){
//        for(int i=0; i<s.length(); ++i){
//            String str = "";
//            //If the character in the string is a number, looks ahead for following digits and concatenates them to a string.
//            if(Character.isDigit(s.charAt(i))){
//                str += s.charAt(i);
//                for(int j=i+1; j<s.length();++j){
//                    if(j <= s.length()){
//                        if(Character.isDigit(s.charAt(j))){
//                            str += s.charAt(j);
//                        } else {
//                            break;
//                        }
//                    }
//                }
//                //Parses the string containing a number and inserts it in the queue. This number can contain multiple digits.
//                q.insertBack(Integer.parseInt(str));
//                //Moves ahead in the loop through the expression by the number of digits the number contains.
//                i += str.length()-1;
//                continue;
//            }
//            /**
//             * The following switch statement handles operators and parentheses
//             * and places them in either a stack or queue according to the rules
//             * for converting from infix expressions to postfix.
//             */
//            switch(s.charAt(i)){
//                case '(':
//                    st.push(s.charAt(i));
//                    break;
//                case '*':
//                    if(st.top != null){
//                        if(st.top.data.equals('+') || st.top.data.equals('-')){
//                            st.push(s.charAt(i));
//                            break;
//                        } else {
//                            if(st.top != null && !st.top.data.equals('(')){
//                                q.insertBack(st.top.data);
//                                st.pop();
//                            }
//                            st.push(s.charAt(i));
//                        }
//                    } else {
//                        st.push(s.charAt(i));
//                    }
//                    break;
//                case '/':
//                    if(st.top != null){
//                        if(st.top.data.equals('+') || st.top.data.equals('-')){
//                            st.push(s.charAt(i));
//                            break;
//                        } else {
//                            if(st.top != null && !st.top.data.equals('(')){
//                                q.insertBack(st.top.data);
//                                st.pop();
//                            }
//                            st.push(s.charAt(i));
//                        }
//                    } else {
//                        st.push(s.charAt(i));
//                    }
//                    break;
//                case '%':
//                    if(st.top != null){
//                        if(st.top.data.equals('+') || st.top.data.equals('-')){
//                            st.push(s.charAt(i));
//                            break;
//                        } else {
//                            if(st.top != null && !st.top.data.equals('(')){
//                                q.insertBack(st.top.data);
//                                st.pop();
//                            }
//                            st.push(s.charAt(i));
//                        }
//                    } else {
//                        st.push(s.charAt(i));
//                    }
//                    break;
//                case '+':
//                    if(st.top != null && !st.top.data.equals('(')){
//                        q.insertBack(st.top.data);
//                        st.pop();
//                    }
//                    st.push(s.charAt(i));
//                    break;
//                case '-':
//                    if(st.top != null && !st.top.data.equals('(')){
//                        q.insertBack(st.top.data);
//                        st.pop();
//                    }
//                    st.push(s.charAt(i));
//                    break;
//                case ')':
//                    while(st.top != null && !st.top.data.equals('(')){
//                        q.insertBack(st.top.data);
//                        st.pop();
//                    }
//                    st.pop();
//                    break;
//            }
//        }
//        /*
//        Once the entire expression has been read and elements of the expression
//        have been places into either the stack or queue, any remaining operators
//        are popped from the stack and are inserted into the queue.
//        */
//        while(st.top != null){
//            q.insertBack(st.top.data);
//            st.pop();
//        }
//    }
    
    /**
     * Utilizing a queue containing elements of a postfix expression, handles
     * stack and queue operations to evaluate the postfix expression and assign
     * the result to a global result variable for output.
     */
//  public static void evalPostfix(){
//        int op1, op2;
//        if(q.front == null) return;
//        while(!q.isEmpty()){
//            //If the frontmost element of the queue is an integer, push onto the stack
//            if(q.front.data instanceof Integer){
//                st.push(q.front.data);
//                q.removeFront();
//            }
//            /*
//            If the frontmost element of the queue is not an integer, pop two elements
//            from the stack and apply the operator held at the front of the queue.
//            Push the result of this operation onto the stack.
//            */
//            else if(q.front.data.equals('+')){
//                q.removeFront();
//                op2 = (Integer)st.top.data;
//                st.pop();
//                op1 = (Integer)st.top.data;
//                st.pop();
//                st.push(op1 + op2);
//            }
//            else if(q.front.data.equals('-')){
//                q.removeFront();
//                op2 = (Integer)st.top.data;
//                st.pop();
//                op1 = (Integer)st.top.data;
//                st.pop();
//                st.push(op1 - op2);
//            }
//            else if(q.front.data.equals('*')){
//                q.removeFront();
//                op2 = (Integer)st.top.data;
//                st.pop();
//                op1 = (Integer)st.top.data;
//                st.pop();
//                st.push(op1 * op2);
//            }
//            else if(q.front.data.equals('/')){
//                q.removeFront();
//                op2 = (Integer)st.top.data;
//                st.pop();
//                op1 = (Integer)st.top.data;
//                st.pop();
//                st.push(op1 / op2);
//            }
//            else if(q.front.data.equals('%')){
//                q.removeFront();
//                op2 = (Integer)st.top.data;
//                st.pop();
//                op1 = (Integer)st.top.data;
//                st.pop();
//                st.push(op1 % op2);
//            }
//            /*
//            After each operation, store the result of that operation at the top 
//            of the stack as the result. Once the expression has been evaluated 
//            completely, this value will be the final result of the expression.
//            */
//            result = (Integer)st.top.data;
//        }
//        /*
//        After evaluating the expression, empties the stack in preparation of
//        further evaluations.
//        */
//        while(st.top != null){
//            st.pop();
//        }
//    }
}
