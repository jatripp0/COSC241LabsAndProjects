package lab;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import collection.MyQueue;
import collection.MyStack;

/**
 * Executes the instructions for COSC 241 Lab 7
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 * @version 1.0
 */
public class Lab7 {
    
    /**
     * Executes the instructions for COSC 241 Lab 7 and will be
     * run within the main method of the Main class.
     */
    public static void test(){
        
        File outputFile = new File("../COSC241_L7_Output_jatripp0.txt");
        //Step 4a) Create a random number generator
        Random r  = new Random(System.currentTimeMillis());
        //Step 4b) Create an instance of MyStack and MyQueue
        MyStack s = new MyStack();
        MyQueue q = new MyQueue();
        int num;
        
        //Step 4c) Add 30 randomly generated numbers into the stack and queue
        System.out.println("Adding elements to the stack and queue...");
        for(int i=0; i<30; ++i){
            num = r.nextInt();
            //Statements broken by stack conversion to MBTN
            //s.push(num);
            //q.insertBack(num);
        }
        
        //Step 4d) Do 20 pop calls on the stack and queue
        for(int i=0; i<20; ++i){
            s.pop();
            q.removeFront();
        }
        
        //Step 4e) Write the contents of the stack to the output file
        //Step 4f) Write the contents of the queue to the output file
        System.out.println("Writing to file...");
        try{
            if(!outputFile.exists()){
                outputFile.createNewFile();
            }
            try (PrintWriter outputToFile = new PrintWriter(outputFile)) {
                    outputToFile.println(s.toString());
                    outputToFile.println(q.toString());
            }
        }
        catch(IOException e){
            
        }
        System.out.println("Done!");
    }
}
