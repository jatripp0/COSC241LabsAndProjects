package lab;

import collection.SLList;
import collection.SortedSLList;

/**
 * Executes the instructions for COSC 241 Lab 6
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻ Tripp (╯°□°）╯︵ ┻━┻
 * @version 1.0
 */
public class Lab6 {
    
    /**
     * Executes the instructions for COSC 241 Lab 6 and will be
     * run within the main method of the Main class.
     */
    public static void test(){
        
        //Step 5a - Create a simpleList of SLList type
        SLList simpleList = new SLList();
        
        /*
        Step 5b - Add the first 30 perfect square numbers to the
        simple list using append and insert alternatively.
        */
        for(int i=1; i<31; ++i){
            
            /*
            Alternates using append and insert for each element added to the list.
            This results in elements being added to the end and beginning of the list, respectively.
            */
            if(i%2 == 0){
                //Statement broken by SLList conversion to MBTN
                //simpleList.append((int)Math.pow(i, 2));
            }
            else{
                //Statement broken by SLList conversion to MBTN
                //simpleList.insert((int)Math.pow(i, 2));
            }
        }
        
        //Step 5c - Print the simpleList
        System.out.println(simpleList.toString());
        
        //Step 5d - Remove elements from the simpleList
        simpleList.remove(25);
        simpleList.remove(36);
        simpleList.remove(64);
        simpleList.remove(100);
        simpleList.remove(400);
        
        //Step 5e - Print the simpleList
        System.out.println(simpleList.toString());
        
        //Step 5f - Create a sortedList of SortedSLList type
        SortedSLList sortedList = new SortedSLList();
        
        /*
        Step 5g - Add the first 30 perfect square numbers to the
        sortedList using insert.
        */
        for(int i=1; i<31; ++i){
            //Statement broken by SLList conversion to MBTN
            //sortedList.insert((int)Math.pow(i, 2));
        }
        
        //Step 5h - Print the sortedList
        System.out.println(sortedList.toString());
        
        //Step 5i - Remove elements from the sortedList
        sortedList.remove(1);
        sortedList.remove(25);
        sortedList.remove(36);
        sortedList.remove(64);
        sortedList.remove(144);
        sortedList.remove(400);
        sortedList.remove(900);
        
        //Step 5j - Print the sortedList
        System.out.println(sortedList.toString());
        
        //Step 5k - Add elements back to the sortedList
        //Statement broken by SLList conversion to MBTN
        /*
        sortedList.insert(1);
        sortedList.insert(64);
        sortedList.insert(400);
        sortedList.insert(900);
        */
        
        //Step 5l - Print the sortedList
        System.out.println(sortedList.toString());
    }
}
