package lab;

import collection.*;
import java.util.Random;

/**
 * Executes the instructions for COSC 241 Lab 5
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻ Tripp (╯°□°）╯︵ ┻━┻
 * @version 1.0
 */
public class Lab5 {
    
    /**
     * This method will execute the instructions for COSC 241 Lab 5 and will be
     * run within the main method of the Main class.
     */
    public static void test(){
        sortTest("Bubble Sort", 0);
        sortTest("Selection Sort", 1);
        sortTest("Merge Sort", 2);
        sortTest("Quick Sort", 3);
        sortTest("Insertion Sort", 4);
        sortTest("Shell Sort", 5);
    }
    
    /**
     * Executes the various sorting algorithms on a vector of 30,000 elements
     * and produces information about the execution of the sorting operations.
     * @param sortName the name of the sorting algorithm being used
     * @param testCase a number to control the switch for the sorting algorithms
     */
    public static void sortTest(String sortName, int testCase){
        
        int i;
        MyVector v = new MyVector();
        Comparable[] temp = new Comparable[30000];
        v.ensureCapacity(30000);
        long startTime, endTime, runTime;
        Random r = new Random(20151015);
        for(i=0; i<30000; ++i){
            v.append(r.nextInt(100000));
        }

        startTime = System.currentTimeMillis();
        //executes the sorting algorithm determined by the testCase number
        switch (testCase){
            case 0: MySort.bubbleSort(v);
                    break;
            case 1: MySort.selectionSort(v);
                    break;
            case 2: MySort.mergeSort(v, temp, 0, v.size()-1);
                    break;
            case 3: MySort.quickSort(v, 0, v.size()-1);
                    break;
            case 4: MySort.insertionSort(v, 0, v.size()-1);
                    break;
            case 5: MySort.shellSort(v);
                    break;
            default: sortName = "Unsorted";
                    break;
        }
        endTime = System.currentTimeMillis();
        runTime = endTime-startTime;
        System.out.println(getResults(v, sortName, runTime));
    }
    
    /**
     * Creates a string representation for the information about the sorted vectors
     * as detailed in the instructions for COSC 241 Lab 5
     * @param v the sorted vector
     * @param sortName the name of the sorting algorithm that was executed
     * @param runTime the runtime for the executed algorithm
     * @return the string representation of the sorting algorithm results
     */
    public static String getResults(MyVector v, String sortName, long runTime){
        
        if(v.size() >= 30000)
            return "Sorting Algorithm: "+sortName+"\nRun Time: "+runTime+" milliseconds\n"
                + "1st element: "+v.elementAt(0)+"\t2nd element: "+v.elementAt(1)+"\n"
                + "3rd element: "+v.elementAt(2)+"\t10,000th element: "+v.elementAt(9999)+"\n"
                + "20,000th element: "+v.elementAt(19999)+"\t30,000th element: "+v.elementAt(29999)+"\n";
        else
            return "Error: Insuficient number of elements in the vector.\n"
                    + "Required: 30,000";
    }
}
