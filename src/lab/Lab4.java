package lab;

import java.util.Scanner;

/**
 * Executes the instructions for COSC 241 Lab 4
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻ Tripp (╯°□°）╯︵ ┻━┻
 * @version 1.0
 */
public class Lab4 {
    
    /**
     * This method will execute the instructions for COSC 241 Lab 4 and will be
     * run within the main method of the Main class.
     */
    public static void test()
    {
        //boolean condition to continue program
        boolean stop = false;
        
        //creates scanner using try-with-resources to automatically close the scanner following the execution of the method
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Hello, this program will determine if a word you enter is a palindrome.");
            System.out.println("\nA palindrome is a word whose meaning may be interpreted the same way in \neither the forward or reverse direction.");
            
            //continue running while user wants to keep testing words
            while(stop == false)
            {
                System.out.println("\nPlease enter a word (containing no white space):");
                //converts input string to lowercase to avoid inaccuracy in character comparison
                String word = scan.nextLine().toLowerCase();
                
                //handles cases where the input string contains white space or is completely empty
                if(word.contains(" "))
                {
                    System.out.println("\nWhite space detected. Please try again and enter a word with no white space.");
                    System.exit(0);
                }
                if(word.isEmpty())
                {
                    System.out.println("\nNo string detected. Please try again and enter a word with no white space.");
                    System.exit(0);
                }
                
                //answers whether the input string is a palindrome using the recursive method
                if(isPalindrome(word, 0, word.length()-1))
                    System.out.println("\nThe word you entered is a palindrome!");
                else
                    System.out.println("\nThe word you entered is not a palindrome.");
                
                System.out.println("\nWould you like to test another word?\nPress 'x' to exit, press any other key to continue.");
                
                if(scan.nextLine().toLowerCase().equals("x"))
                    stop = true;
            }
        }
    }
    
    /**
     * Recursive method to determine if the given string is a palindrome.
     * @param s the input string
     * @param first the first index of the input string
     * @param last the last index of the input string
     * @return true if the input string is a palindrome, false if the string is not
     */
    public static boolean isPalindrome(String s, int first, int last)
    {
        if(s.charAt(first) != s.charAt(last))
            return false;
        if(first > last)
            return true;
        return isPalindrome(s, first+1, last-1);
    }
}
