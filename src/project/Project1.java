package project;

import collection.MySet;

/**
 *Demonstrate the methods of the MySet class
 * by creating sets that contain elements of
 * the Fibonacci sequence and positive odd 
 * integers. The test method of this class
 * calls the various methods of MySet.
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 * @version 1.0
 */
public class Project1 {
    
    /**
     * A test method to perform the functions
     * of the MySet class, including intersection,
     * union, and symmetric difference.
     */
    public static void test(){
        
        //Step 1 - Create two instances of the MySet class
        MySet oddNumSet = new MySet();
        MySet fibonacciNumSet = new MySet();
        
        /*
        Step 2 - Insert the first 29 Fibonacci numbers into
        the fibonacciNumSet (actual set contains 28 elements, since the second
        zero is excluded from the set as a duplicate. To get 29 elements excluding
        the second 1, change the condition of the loop from i<29 to i<30.
        */
        int a=0, b=1,c;
        fibonacciNumSet.insert(a);
        fibonacciNumSet.insert(b);
        for(int i=2; i<29; ++i){
            c = a+b;
            fibonacciNumSet.insert(c);
            a=b;
            b=c;
        }
        
        //Step 3 - Print out the fibonacciNumSet
        System.out.println("Fibonacci Number Set:\n" + fibonacciNumSet.toString());
        
        /*
        Step 4 - Insert the first 39 positive odd numbers into
        the oddNumSet
        */
        int odd = 1;
        for(int i=0; i<39; ++i){
            oddNumSet.insert(odd);
            odd+=2;
        }
        
        //Step 5 - Print out the oddNumSet
        System.out.println("Odd Number Set:\n" + oddNumSet.toString());
        
        //Step 6 - Get the intersection set of the above two sets
        MySet intersectionSet = fibonacciNumSet.intersection(oddNumSet);
        
        //Step 7 - Print out the intersection set
        System.out.println("Intersection Set:\n" + intersectionSet.toString());
        
        //Step 8 - Get the symmetric difference set of the above two sets
        MySet symDiffSet = fibonacciNumSet.symmetricDifference(oddNumSet);
        
        //Step 9 - Print out the symmetric difference set
        System.out.println("Symmetric Difference Set:\n" + symDiffSet.toString());
        
        //Step 10 - Get the union set of the above two sets
        MySet unionSet = fibonacciNumSet.union(oddNumSet);
        
        //Step 11 - Print out the union set
        System.out.println("Union Set:\n" + unionSet.toString());
        
    }
}
