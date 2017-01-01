package lab;

import collection.DLList;
import collection.DLListNode;
import collection.MyDeque;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Executes the instructions for COSC 241 Lab 8
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 * @version 1.0
 */
public class Lab8 {
    
    /**
     * Executes the instructions for COSC 241 Lab 8 and will be
     * run within the main method of the Main class.
     */
    public static void test(){
        DLList simpleDLList = new DLList();
        MyDeque simpleDeque = new MyDeque();
        List<String> lineList = null;
        File out = new File("../COSC241_L8_Output_jatripp0.txt");
        
        try{
            lineList = Files.readAllLines(Paths.get("../COSC241_L8_Input.txt").toAbsolutePath());
            if(!out.exists()){
                out.createNewFile();
            }
            
            try (PrintWriter outToFile = new PrintWriter(out)) {
                outToFile.println("Johnathan Tripp - Lab 8 Output");
                outToFile.println();
                for(String s : lineList){
                    String temp = s.trim();
                    for(int i=0; i < temp.length(); ++i){
                        //Statement broken by DLList conversion to MBTN
                        //simpleDLList.append(temp.charAt(i));
                        //simpleDeque.insertFront(temp.charAt(i));
                    }

                    DLListNode ref = simpleDLList.head;
                    boolean isP = true;
                    while(ref != null){
                        if(((Comparable)ref.data).compareTo(simpleDeque.removeFront()) != 0)
                            isP = false;
                        ref = ref.next;
                    }

                    if(isP){
                        outToFile.println("\"" + temp + "\" is a palindrome.");
                    } else {
                        outToFile.println("\"" + temp + "\" is not palindrome.");
                    }
                    simpleDLList.clear();
                    simpleDeque.clear();
                } 
            }
        }
        catch(IOException e){
            System.out.println(e.toString());
            System.exit(0);
        } 
    }
}
