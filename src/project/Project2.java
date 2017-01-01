package project;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Class to run the number-to-words matching program for COSC 241 Project 2.
 * See the WordMatcher class in the project collection for the methods that
 * satisfy the bonus points requirements for COSC 241 Project 2.
 * Note: The WordMatcher, NumberModifiers, and WordFilesIO classes are all a part of this project. 
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 * @version 1.0
 */
public class Project2 {
    
    private static String number;
    private static final String fpath = "../COSC241_P2_EnglishWordList.txt";
    private static List<String> wordList;
    public static List<String> resultsList;
    public static int comboListSize;
    
    /**
     * The test method of the Project 2 class. Prompts the user for a 7 digit
     * input, excluding 0 and 1, and uses searching methods to find words that
     * map to the given input.
     */
    public static void test(){
        
        boolean isValid;
        Scanner scan = new Scanner(System.in);
        
        /*
        Attempts to read in the word list file from the project's parent directory.
        Failure to read the file will result in an error message and exit from the
        program.
        */
        try{
            wordList = WordFilesIO.readFile(fpath);
        }
        catch (IOException e){
            System.out.println("Error: IOException. Please check that the EnglishWordList file is located in the correct directory.");
            System.exit(0);
        }
        System.out.println("Hello! This program will give you word representations for a telephone number you enter.\n"
                + "Example: 776-4726 --> PROGRAM\n");
        
        do{
            comboListSize = 0;
            isValid = true;
            System.out.println("Please enter a 7 digit telephone number (valid digits [2-9]). Do not include dashes or spaces:");
            number = scan.nextLine();
            
            //Error handling cases for the phone number input.
            if(number.toLowerCase().equals("x")){
                System.out.println("Goodbye!");
                System.exit(0);
            }
            else if(number.length() != 7){
                System.out.println("\nInvalid Entry: Telephone number must be 7 digits. Please try again. Press 'x' to exit, or any other key to try again.\n");
                isValid = false;
            }
            else if(number.contains("0") || number.contains("1")){
                System.out.println("\nInvalid Entry: Number cannot contain 0 or 1. Please try again. Press 'x' to exit, or any other key to try again.\n");
                isValid = false;
            }
            for(int i=0; i<number.length(); ++i){
                if(!Character.isDigit(number.charAt(i)) || number.contains(" ")){
                    System.out.println("\nInvalid Entry: 7-digit number required. "
                        + "Do not include letters, dashes or spaces. Example: 8675329 NOT 867-5329\n"
                            + "Please try again. Press 'x' to exit, or any other key to try again.");
                    isValid = false;
                    break;
                }
            }
            
            /*
            If the given phone number is a valid input, locates the words in the
            word list file that map to the number, as well as any possible combination
            of words that match.
            */
            if(isValid == true){
                //Gets 7-letter words matching the number and stores to a list of results.
                resultsList = WordMatcher.getWords(wordList, number, NumberModifiers.numToStart(number), NumberModifiers.numToEnd(number));
                //Gets all other combinations of words matching the number and stores to the list of results.
                getWordCombos(wordList, number);
                //Prints out the matches of the given phone number.
                System.out.println(getResults());
                
                System.out.println("Would you like to try another number?\n");
                System.out.println("Press x to exit, press any other key to continue.");
            }    
        } while(!scan.nextLine().toLowerCase().equals("x"));
        System.out.println("Goodbye!");
    }
    
    /**
     * This method locates every possible combination of words that match
     * the telephone number, if any exist. Please see the word combo methods of
     * the WordMatcher class to see the methods responsible for retrieving these
     * results. This method and the corresponding methods of the WordMatcher class
     * fulfill the bonus points requirements of Project 2.
     * @param words a List containing all the possible words from the EnglishWordList text file.
     * @param number the input number created by the user.
     */
    public static void getWordCombos(List<String> words, String number){
        
        WordMatcher.getTwoWordCombos(words, number);
        WordMatcher.getThreeWordCombos(words, number);
        WordMatcher.getFourWordCombos(words, number);
        WordMatcher.getFiveWordCombos(words, number);
        WordMatcher.getSixWordCombos(words, number);
        WordMatcher.getSevenWordCombos(words, number);
    }
    
    /**
     * Creates a string representation of the list of words matching the input
     * phone number. This method can be used to print the results of the program.
     * @return a String representation of this project's results.
     */
    public static String getResults(){
        int i;
        String resultString;
        String formattedNum = number.substring(0, 3) + "-" + number.substring(3);
        
        if(resultsList.isEmpty()){
            return "\nThere were no matches found for the phone number: " + formattedNum;
        } else {
            resultString = "\nThere are " + resultsList.size() + " matches (" + comboListSize + " word combinations) for the phone number you entered (" + formattedNum + "):\n\n";
            for(i=0; i<resultsList.size(); ++i){
                resultString += (i+1) + ": " + resultsList.get(i) + "\n";
            }
        }
        return resultString;
    }
}
