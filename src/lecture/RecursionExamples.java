/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture;
import collection.*;
/**
 *
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 */
public class RecursionExamples {
    
    public static int factorial(int n){
        //assume n > 0
        if(n == 1){
            return 1;
        }
        
        return n * factorial(n-1);
    }
    
    public static int power(int a, int n){
        
        if(n ==0){
            return 1;
        }
        return a * power(a, n-1);
    }
    
    public static int fibonacci(int n){
        //assume n >= 1
        if(n == 1){
            return 0;
        }
        else if(n == 2){
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
    
    public static int binarySearch(MyVector v, Comparable target, int left, int right){
        //assume left, right have the initial values of 0, v.size()-1, respectively
        if(left > right){
            return -1;
        }
        
        int middle = (right + left)/2;
        
        if(target.compareTo(v.elementAt(middle)) == 0)
        {
            return middle;
        }
        else if(target.compareTo(v.elementAt(middle)) > 0)
        {
            return binarySearch(v, target, middle+1, right);
        }
        else
        {
            return binarySearch(v, target, left, middle-1);
        }
    }
    
    public static int A(int x, int y)
    {
        if(x==0) return 1;
        if(x==1 && y==0) return 2;
        if(y==0) return (x+2);
        return A(A(x-1, y), y-1);
    }
    
    public static boolean isPalindrome(String s, int first, int last)
    {
        if(s.charAt(first) != s.charAt(last))
            return false;
        if(first > last)
            return true;
        return isPalindrome(s, first+1, last-1);
    }
}
