package lab;

import collection.MyVector;

/**
 *Execute the instructions for COSC 241 Lab 2
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻ Tripp (╯°□°）╯︵ ┻━┻
 * @version 1.0
 */
public class Lab2 {
    
    /**
     * This method will execute the instructions for COSC 241 Lab 2 and will be
     * run within the main method of the Main class.
     */
    public static void test(){
        //Create an instance of MyVector (Step 1)
        MyVector v = new MyVector();
        
        /*Loads the first 29 numbers in the Fibonacci sequence (starting at 0) 
        into the vector. The first values, 0 and 1, are loaded manually to avoid
        excessive complexity in the loop. (Step 2)
        */
        int a=0, b=1,c;
        v.append(a);
        v.append(b);
        for(int i=2; i<29; ++i){
            c = a+b;
            v.append(c);
            a=b;
            b=c;
        }
        
        //Print out the vector (Step 3)
        System.out.println("Vector with Fibonacci Sequence");
        System.out.println(v.toString());
        
        //Reverse the elements (Step 4)
        v.reverse();
        
        //Make a clone of the vector (Step 5)
        MyVector clone = v.clone();
        
        //Print out the original vector (Step 6)
        System.out.println("Original Vector Reversed");
        System.out.println(v.toString());
        
        //Remove all elements at odd indices of the original vector. (Step 7)
        for(int i=v.size()-1; i >= 0; i-=2){
            if(i % 2 == 0)
                i-=1;
            v.removeAt(i);
        }
        
        /*Print out the original vector with odd elements at odd indices removed
         (Step 8)
        */
        System.out.println("Original Vector with elements at odd indices removed.");
        System.out.println(v.toString());
        
        //Reverse the cloned vector (Step 9)
        clone.reverse();
        
        //Print out the cloned vector (Step 10)
        System.out.println("Cloned Vector");
        System.out.println(clone.toString());
        
        //Merge the cloned vector to the original vector (Step 11)
        v.merge(clone);
        
        //Print out the original vector (Step 12)
        System.out.println("Original Vector (Merged with clone)");
        System.out.println(v.toString());
        
    }
}
