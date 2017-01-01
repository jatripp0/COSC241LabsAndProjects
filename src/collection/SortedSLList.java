package collection;

/**
 * A class defining a sorted, singularly-linked list of elements.
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻ Tripp (╯°□°）╯︵ ┻━┻
 * @version 1.0
 */
public class SortedSLList {
    
    private int size;
    private SLListNode head;
    private SLListNode tail;
    
    /**
     * Public constructor for the SortedSLList class.
     */
    public SortedSLList(){
        head = tail = null;
    }
    
    /**
     * Sets the data fields of all elements to null.
     */
    public void clear(){
        
        if(head == null){
            return;
        }
        SLListNode ref = head;
        while(ref.next != null){
            ref.data = null;
            ref = ref.next;
        }
    }
    
    /**
     * Determines if the list is empty (all elements are null) and returns the result.
     * @return true if the list is empty, false if it is not.
     */
    public boolean isEmpty(){
        
        if(head == null) return true;
        SLListNode ref = head;
        while(ref != tail.next){
            if(ref.data != null){
                return false;
            }
        }
        return true;
    }
    
    /**
     * Gets the size of the current list.
     * @return the number of elements contained in the list.
     */
    public int size(){
        return size;
    }
    
    /**
     * Adds elements to the list in order from least to greatest.
     * @param element the Object to be added to the list.
     */
    public void insert(MyBinaryTreeNode element){
        
        SLListNode newNode = new SLListNode(element, null);
        
        if(size == 0){
            head = tail = newNode;
            ++size;
            return;
        }
        SLListNode ref = head;
        if(((Comparable)ref.data).compareTo(element) >= 0){
            newNode.next = ref;
            head = newNode;
            ++size;
            return;
        }
        while(ref.next != null){
            if(((Comparable)ref.next.data).compareTo(element) >= 0){
                newNode.next = ref.next;
                ref.next = newNode;
                ++size;
                return;
            }
            ref = ref.next;
        }
        tail = tail.next = newNode;
        ++size;
    }
    
    /**
     * Removes the specified Object from the list, if it exists.
     * @param element the Object to be removed from the list.
     * @return true if the specified Object was removed, false if it was not.
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
     * Creates and returns a String representation of the SortedSLList.
     * @return the formatted String.
     */
    @Override
    public String toString(){
        
        String out = "The " + size() + " element Sorted SLList contains:\n";
        
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
