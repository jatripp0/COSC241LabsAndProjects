/*
 * 'LIFO' Stack Data Structure Implementation
 */
package collection;

/**
 * A class to represent a stack data structure.
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 */
public class MyStack {
    
    public SLListNode top;
    
    /**
     * 
     * @return 
     */
    public MyBinaryTreeNode pop(){
        
        if(top == null) return null;
        MyBinaryTreeNode temp = top.data;
        top = top.next;
        return temp;
    }
    
    /**
     * 
     * @param element 
     */
    public void push(MyBinaryTreeNode element){
        
        top = new SLListNode(element, top);
    }
    
    /**
     * 
     * @return 
     */
    public MyBinaryTreeNode top(){
        
        return top == null ? null : top.data;
    }
    
    @Override
    public String toString(){
        int n = 1;
        String str = "This Stack contains: ";
        if(top == null){
            return "The stack contains no elements.";
        }
        SLListNode ref = top;
        str += "Top:\t";
        while(ref.next != null){
            str += n + ": " + ref.data + "\t-->\t";
            ref = ref.next;
            n++;
        }
        return str + n + ": " + ref.data + "\t--> null";
    }
}
