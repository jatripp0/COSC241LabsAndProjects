package lab;
import collection.*;
import java.util.Random;
import java.util.Scanner;

/**
 * Execute the instructions for COSC 214 Lab 3
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻ Tripp (╯°□°）╯︵ ┻━┻
 * @version 1.0
 */
public class Lab3 {
    
    private static Scanner scan;
    /**
     * This method will execute the instructions for COSC 241 Lab 3 and will be
     * run within the main method of the Main class.
     */
    public static void test()
    {
        //Part a) Create a numVec of MyVector type
        MyVector numVec = new MyVector();
        //numVec.ensureCapacity(150);
        Random r = new Random();
        //uses System.nanoTime() as the random seed
        r.setSeed(System.nanoTime());
        
        //Part b) Generate a sequence of 150 random integers in the range [100, 999]
        for(int i=0; i<150; ++i)
        {
            numVec.append(r.nextInt(900)+100);
        }
        
        //Part c) Sort numVec using bubbleSort
        MySort.bubbleSort(numVec);
        
        //Part d) Print out numVec to the screen
        System.out.println(numVec.toString());
        
        //Part e) Prompt user to type in a number through keyboard
        int num = getUserInput();
        
        //Part f) Search the number using linearSearchSorted
        if(MySearch.linearSearchSorted(numVec, num) == -1){
            System.out.println("Number " + num + " was not found.");
        }
        else{
            System.out.println("Found " + num + " at index: " + MySearch.linearSearchSorted(numVec, num));
        }
        
        //Part g) Call numVec.removeRange(5, 55)
        numVec.removeRange(5, 55);
        
        //Part h) Then call numVec.reverse()
        numVec.reverse();
        
        //Part i) Sort numVec using selectionSort
        MySort.selectionSort(numVec);
        
        //Part j) Print out numVec to the screen
        System.out.println(numVec.toString());
        
        //Part k) Prompt the user to type in a number through keyboard
        num = getUserInput();
        
        //Part l) Search that number using binarySearch
        if(MySearch.binarySearch(numVec, num) == -1){
            System.out.println("Number " + num + " was not found.");
        }
        else{
            System.out.println("Found " + num + " at index: " + MySearch.binarySearch(numVec, num));
        }
        scan.close();
    }
    
    /**
     * Processes user input to retrieve an integer number
     * @return the number retrieved from user input
     */
    public static int getUserInput(){
        scan = new Scanner(System.in);
        int n = 0;
        System.out.println("Please enter an integer number: ");
        try{
            n = scan.nextInt();
        }
        catch(Exception e){
            System.out.println("Input not recognized.");
            n = 0;
        }
        return n;  
    }
}
