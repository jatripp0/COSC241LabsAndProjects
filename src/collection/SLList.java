package collection;

/**
 * A class defining an unsorted, singularly-linked list
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 */
public class SLList {
    
    private int size;
    private SLListNode head;
    private SLListNode tail;
    
    /**
     * Public constructor for the SLList class.
     */
    public SLList(){
        head = tail = null;
    }
    
    /**
     * Adds the specified Object to the end of the list.
     * @param element the Object to be added to the list.
     */
    public void append(MyBinaryTreeNode element){
        
        if(head == null){
            head = tail = new SLListNode(element, null);
            size++;
        } else {
            tail = tail.next = new SLListNode(element, null);
            size++;
        }
    }
    
    /**
     * Inserts the specified Object at the beginning of the list.
     * @param element the Object to be inserted into the list.
     */
    public void insert(MyBinaryTreeNode element){
        
        if(head == null){
            head = tail = new SLListNode(element, null);
            size++;
        } else {
            head = new SLListNode(element, head);
            size++;
        }
    }
    
    /**
     * Removes the specified Object from the list, if it exists.
     * @param element the Object to be removed from the list.
     * @return true if the Object was removed, false if it was not.
     */
    public boolean remove(Object element){
        
        if(element == null) return false;
        if(head == null) return false;
        if(((Comparable)head.data).compareTo(element) == 0){
            if(head == tail){
                head = tail = null;
                size--;
                return true;
            }
            head = head.next;
            size--;
            return true;
        }
        if(head == tail) return false;
        SLListNode ref = head;
        while(ref.next != tail){
            if(((Comparable)ref.next.data).compareTo(element) == 0){
                ref.next = ref.next.next;
                size--;
                return true;
            }
            ref = ref.next;
        }
        if(((Comparable)tail.data).compareTo(element) == 0){
            ref.next = null;
            tail = ref;
            size--;
            return true;
        }
        return false;
    }
    
    /**
     * Get the size of the current list.
     * @return the number of elements in the list.
     */
    public int size(){
        return size;
    }
    
    /**
     * Creates and returns a String representation of the SLList.
     * @return the formatted String.
     */
    @Override
    public String toString(){
        
        String out = "The " + size() + " element SLList contains:\n";
        
        SLListNode ref = head;
        if(ref == null){
            return out + "0 nodes.";
        } else {
            out += "head -->\t";
        }
        
        while(ref.next != null){
            out += ref.data + "\t-->\t";
            ref = ref.next;
        }
 
        return out + ref.data + "\t--> null";
    }
}
