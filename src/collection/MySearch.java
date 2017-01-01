package collection;

/**
 *Implements all the methods of the MySearch class as defined 
 * in the instructions for COSC 241 Lab 3
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻ Tripp (╯°□°）╯︵ ┻━┻
 * @version 1.0
 */
public class MySearch {
    
    /**
     * Private constructor
     */
    private MySearch(){}
    
    /**
     * Searches for the given element in the given vector using binary search
     * @param vec the vector to be searched
     * @param target the target element to be searched for
     * @return the index of the target element if found, -1 if not
     */
    public static int binarySearch(MyVector vec, Comparable target){
        int first = 0, middle, last = vec.size()-1;
        
        while(first <= last){
            middle = (first + last)/2;
            
            if(target.compareTo(vec.elementAt(middle)) < 0){
                last = middle - 1;
            }
            else if(target.compareTo(vec.elementAt(middle)) > 0){
                first = middle + 1;
            }
            else{
                return middle;
            }
            //if target was not found
        }
        return -1;
    }
    
    /**
     * Searches for the given element in the given vector using linear search of
     * a sorted list of elements
     * @param vec the sorted vector to be searched
     * @param target the target element to be searched for
     * @return the index of the target element if found, -1 if not
     */
    public static int linearSearchSorted(MyVector vec, Comparable target){
        
        for(int i=0; i<vec.size(); ++i){
            if(target.compareTo(vec.elementAt(i)) == 0)
                return i;
            else if(target.compareTo(vec.elementAt(i)) < 0)
                return -1;
        }
        return -1;
    }

}
