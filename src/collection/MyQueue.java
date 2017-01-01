/*
 * 'FIFO' Queue Data Structure Implementation
 */
package collection;

import collection.SLListNode;

/**
 * A class to represent a queue data structure.
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 */
public class MyQueue {
    
    public SLListNode front;
    public SLListNode rear;
    
    //omitting constructor, clear(), isEmpty(), etc.
    
    public MyQueue(){
        front = rear = null;
    }
    
    /**
     * Inserts an Object at the back of the queue.
     * @param element the Object to be inserted at the back of the queue.
     */
    public void insertBack(MyBinaryTreeNode element){
        
        if(front == null){
            front = rear = new SLListNode(element, null);
            return;
        }
        rear = rear.next = new SLListNode(element, null);
    }
    
    /**
     * Removes the Object at the front of the queue.
     * @return the Object removed, null if the queue is empty.
     */
    public Object removeFront(){
        
        if(front == null) return null;
        Object temp = front.data;
        if(front == rear){
            front = rear = null;
            return temp;
        }
        front = front.next;
        return temp;
    }
    
    /**
     * Gets the Object at the front of the queue.
     * @return the Object at the front of the queue, null if the queue is empty.
     */
    public Object front(){
        
        return front == null ? null : front.data;
        //ternary operator to replace the following:
        /*
        if(front == null){
            return null;
        }
        return front.data;
        */
    }
    
    /**
     * Clears all Objects in the queue.
     */
    public void clear(){
        front = rear = null;
        //do more
    }
    
    /**
     * Determines whether or not the queue is empty.
     * @return true if the queue is empty, false if it is not empty.
     */
    public boolean isEmpty(){
        return front == null;
    }
    
    @Override
    public String toString(){
        int n = 1;
        String str = "This Queue contains: ";
        if(front == null){
            return "The queue contains no elements.";
        }
        SLListNode ref = front;
        str += "Front:\t";
        while(ref.next != null){
            str += n + ": " + ref.data + "\t-->\t";
            ref = ref.next;
            n++;
        }
        return str + n + ": " + ref.data + "\t--> null";
    }
    
    public String toPostfixString(){
        String str = "";
        if(front == null){
            return str;
        }
        SLListNode ref = front;
        while(ref.next != null){
            str += ref.data;
            ref = ref.next;
        }
        return str += ref.data;
    }
}
