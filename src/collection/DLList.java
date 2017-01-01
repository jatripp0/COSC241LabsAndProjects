package collection;

/**
 * A class to represent a doubly-linked list data structure
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 * @version 1.0
 */
public class DLList {
    
    public DLListNode head;
    public DLListNode tail;
    
    /**
     * Public constructor
     */
    public DLList(){
        head = tail = null;
    }
    
    /**
     * Appends an element to the back of the DLList
     * @param element the element to be appended to the list
     */
    public void append(MyBinaryTreeNode element){
        
        if(head == null){
            head = tail = new DLListNode(element, null, null);
        } else {
            tail = tail.next = new DLListNode(element, tail, null);
        }
    }
    
    /**
     * Inserts an element into the front of the DLList
     * @param element the element to be inserted into the list
     */
    public void insert(MyBinaryTreeNode element){
        
        if(head == null){
            head = tail = new DLListNode(element, null, null);
        } else {
            head = head.prev = new DLListNode(element, null, head);
        }
    }
    
    /**
     * Removes the given element from the DLList
     * @param element the element to be removed from the list
     */
    public void remove(Object element){
        
        if(head == null) return;
        if(((Comparable)head.data).compareTo(element) == 0){
            if(head == tail){
                head = tail = null;
                return;
            }
            head = head.next;
            head.prev = null;
            return;
        }
        if(head == tail) return;
        DLListNode ref = head.next;
        while(ref != tail){
            if(((Comparable)ref.data).compareTo(element) == 0){
                ref.prev.next = ref.next;
                ref.next.prev = ref.prev;
                return;
            }
            ref = ref.next;
        }
        if(((Comparable)tail.data).compareTo(element) == 0){
            tail = tail.prev;
            tail.next = null;
        }
    }
    
    /**
     * Clears all elements from the DLList
     */
    public void clear(){
        head = tail = null;
    }
    
    /**
     * Creates a string representation of the DLList
     * @return the string representation of the list
     */
    @Override
    public String toString(){
        String out = "The DLList contains:\n";
        
        DLListNode ref = head;
        if(ref == null){
            return out + "0 Nodes.\n";
        } else {
            out += "head -->\t";
        }
        while(ref != tail){
            out += ref.data + "\t<-->\t";
            ref = ref.next;
        }
        out += ref.data + "\t<-- tail\n";
        
        return out;
    }
}
