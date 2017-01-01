/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab;

import java.util.Vector;

/**
 *
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 */
public class Lab1 {
    
    public static void test(String[] args){
        
        Vector<Object> vector = new Vector<Object>();
        int primitiveInt = 241;
        Integer wrapperInt = new Integer(3542);
        String str = "Johnathan Tripp (╯°□°）╯︵ ┻━┻ Tripp (╯°□°）╯︵ ┻━┻";
        vector.add(primitiveInt);
        vector.add(wrapperInt);
        vector.add(str);
        vector.add(2, new Integer(2158));
        System.out.println("The elements of vector: " + vector);
        System.out.println("The sizeof vector is: " + vector.size());
        System.out.println("The element at position 2 is: " + vector.elementAt(2));
        System.out.println("The first element of vector is: " + vector.firstElement());
        System.out.println("The last element of vector is: " + vector.lastElement());
        vector.removeElementAt(1);
        System.out.println("The elements of vector: " + vector);
        System.out.println("The size of vector is: " + vector.size());
        System.out.println("The element atposition 2 is: " + vector.elementAt(2));
        System.out.println("The first element of vector is: " + vector.firstElement());
        System.out.println("The last element of vector is: " + vector.lastElement());
        
        vector.clear();
        
        System.out.println("\nThe elements of vector are:");
        for(int i=0; i < args.length; i++){
            /*try/catch block to handle exceptions when parsing non-compatible 
              data types to an integer. 0 is added when an exception is caught.
            */
            try{
                vector.add(Integer.parseInt(args[i]));
            }
            catch(NumberFormatException e){
                vector.add(0);
            }
        }
        
        for(int i=0; i < vector.size(); i++){
            System.out.println(vector.elementAt(i));
        }
        
        System.out.println("\nThe elements of vector with odd indices removed are:");
        
        for(int i=vector.size()-1; i >= 0; i-=2){
            if(i % 2 == 0)
                i-=1;
            vector.remove(i);
        }
        
        for(int i=0; i < vector.size(); i++){
            System.out.println(vector.elementAt(i));
        }
    }
}
