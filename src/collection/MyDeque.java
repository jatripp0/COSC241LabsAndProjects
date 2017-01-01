package collection;

/**
 * A class to represent a deque data structure.
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 * @version 1.0
 */
public class MyDeque extends DLList{
    
    /**
     * Public constructor
     */
    public MyDeque(){
        super();
    }
    
    /**
     * Accessor method for the object at the front of the queue
     * @return the Object at the front of the queue
     */
    public Object front(){
        if(head == null) return null;
        return head.data;
    }
    
    /**
     * Accessor method for the object at the back of the queue
     * @return the Object at the back of the queue
     */
    public Object back(){
        if(head == null) return null;
        return tail.data;
    }
    
    /**
     * Inserts an element into the front of the deque
     * @param element the element to be inserted into the queue
     */
    public void insertFront(MyBinaryTreeNode element){
        insert(element);
    }
    
    /**
     * Removes the element at the front of the deque
     * @return the element that was removed
     */
    public Object removeFront(){
        if(head == null) return null;
        Object temp = head.data;
        if(head == tail){
            head = tail = null;
            return temp;
        }
        head = head.next;
        head.prev = null;
        return temp;
    }
    
    /**
     * Inserts an element into the back of the deque
     * @param element the element to be inserted into the deque
     */
    public void insertBack(MyBinaryTreeNode element){
        append(element);
    }
    
    /**
     * Removes the element at the back of the deque
     * @return the element that was removed
     */
    public MyBinaryTreeNode removeBack(){
        if(head == null) return null;
        MyBinaryTreeNode temp = tail.data;
        if(head == tail){
            head = tail = null;
            return temp;
        }
        tail = tail.prev;
        tail.next = null;
        return temp;
    }
}
