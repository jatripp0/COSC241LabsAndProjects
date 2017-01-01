package project;

/**
 * A class containing methods that modify the phone number input from Project 2
 * in order to help locate the words that match the number.
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 * @version 1.0
 */
public class NumberModifiers {
    
    /**
     * Creates a Regular Expression from the phone number input to be used when
     * locating matches for the phone number.
     * @param number the string containing numbers to be converted to a Regular Expression.
     * @return the Regular Expression containing letter mappings of the phone number.
     */
    public static String getRegex(String number){
        return number.replaceAll("2", "[abc]").replaceAll("3", "[def]")
                .replaceAll("4", "[ghi]").replaceAll("5", "[jkl]").replaceAll("6", "[mno]")
                .replaceAll("7", "[pqrs]").replaceAll("8", "[tuv]").replaceAll("9", "[wxyz]");
    }
    
    /**
     * Converts every number of the input parameter to the first corresponding
     * letter it maps to. (example: 2 maps to "a", 9 maps to "w")
     * @param number the string containing numbers to be modified.
     * @return a string of letters to find the beginning of the range of possible matches when using BinarySearch.
     */
    public static String numToStart(String number){
        return number.replaceAll("2", "a").replaceAll("3", "d").replaceAll("4", "g")
                 .replaceAll("5", "j").replaceAll("6", "m").replaceAll("7", "p")
                 .replaceAll("8", "t").replaceAll("9", "w");
    }
    
    /**
     * Converts every number of the input parameter to the last corresponding
     * letter it maps to. (example: 2 maps to "c", 9 maps to "z")
     * @param number the string containing numbers to be modified.
     * @return a string of letters to find the end of the range of possible matches when using BinarySearch.
     */
    public static String numToEnd(String number){
        return number.replaceAll("2", "c").replaceAll("3", "f").replaceAll("4", "i")
                 .replaceAll("5", "l").replaceAll("6", "o").replaceAll("7", "s")
                 .replaceAll("8", "v").replaceAll("9", "z");
    }
}
