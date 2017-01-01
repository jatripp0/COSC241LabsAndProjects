package project;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 * A class containing methods to validate an infix expression before the expression
 * is evaluated in order to prevent calculation or runtime errors.
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 * @version 1.0
 */
public class ExpressionRegulators {
    
    /**
     * Verifies that any opening parentheses or brackets in an expression are 
     * matched by the appropriate number of closing parentheses or brackets.
     * @param s an infix expression
     * @return true if the parentheses or brackets are matched in the expression
     */
    public static boolean allPMatched(String s){
        //Counter variables to keep track of all parentheses and brackets.
        int openP = 0, closeP = 0, openB = 0, closeB = 0;
        for(char c : s.toCharArray()){
            switch(c){
                case '(':
                    openP++;
                    break;
                case ')':
                    //
                    boolean isPPrec = false;
                    for(int i=0; i<s.indexOf(c); ++i){
                        if(s.charAt(i) == '('){
                            isPPrec = true;
                            break;
                        }
                    }
                    if(isPPrec == false) return false;
                    closeP++;
                    break;
                case '[':
                    openB++;
                    break;
                case ']':
                    boolean isBPrec = false;
                    for(int i=0; i<s.indexOf(c); ++i){
                        if(s.charAt(i) == '['){
                            isBPrec = true;
                            break;
                        }
                    }
                    if(isBPrec == false) return false;
                    closeB++;
                    break;
            }
        }
        if(openP == closeP && openB == closeB) return true;
        return false;
    }
    
    /**
     * Verifies that all characters in the infix expression parameter string are
     * valid operands or operators.
     * @param s an infix expression
     * @return true if the expression is valid
     */
    public static boolean allValid(String s){
        Pattern p = Pattern.compile("[0-9]");
        Matcher m;
        for(int i=0; i<s.length(); ++i){
            m = p.matcher("" + s.charAt(i));
            if(m.find()){
                continue;
            }
            switch(s.charAt(i)){
                case ' ':
                    break;
                case '+':
                    break;
                case '-':
                    break;
                case '/':
                    break;
                case '*':
                    break;
                case '%':
                    break;
                case '(':
                    break;
                case ')':
                    break;
                case '[':
                    break;
                case ']':
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
    
    /**
     * Verifies that the operands and operators in an infix expression are in the
     * proper order to be evaluated.
     * @param s an infix expression
     * @return true if the infix expression is in the proper order.
     */
    public static boolean isValidOrder(String s){
        String[] operators = new String[]{"+", "-", "/", "%", "*"};
        for(int i=0; i<operators.length; ++i){
            if(s.startsWith(operators[i]) || s.startsWith(")") || s.startsWith("]")){
                return false;
            }
            if(s.endsWith(operators[i]) || s.endsWith("(") || s.endsWith("[")){
                return false;
            }
        }
        for(int i=0; i<s.length(); ++i){
            for(int j=0; j<operators.length; ++j){
                if(s.charAt(i) == operators[j].charAt(0)){
                    if(!Character.isDigit(s.charAt(i+1)) && s.charAt(i+1) != '(' && s.charAt(i+1) != '['){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
