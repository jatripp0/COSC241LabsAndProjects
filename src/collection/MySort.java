package collection;

/**
 * Implements all the methods of the MySort class as defined
 * in the instructions for COSC 241 Lab 3
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻ Tripp (╯°□°）╯︵ ┻━┻
 * @version 1.0
 */
public class MySort {
    
    /**
     * Private constructor
     */
    private MySort(){}
    
    /**
     * Sorts the given vector using the bubble sort algorithm
     * @param v the vector to be sorted
     */
    public static void bubbleSort(MyVector v){
        
        int i, j, n = v.size();
        Comparable first, second;
        
        for(i=1; i<n; ++i){
            for(j=n-1; j>=i; --j){
                first = (Comparable)v.elementAt(j-1);
                second = (Comparable)v.elementAt(j);
                if(first.compareTo(second) > 0){
                    swap(v, j, j-1);
                }
            }
        }
    }
    
    /**
     * Sorts the given vector using the selection sort algorithm
     * @param v the vector to be sorted
     */
    public static void selectionSort(MyVector v){
        int i, j, n = v.size(), smallestPos;
        Comparable smallest, current;
        //iterate through every element up to the second from the last
        for(i=0; i<n-1; ++i){
            smallestPos = i;
            smallest = (Comparable)v.elementAt(smallestPos);
            //iterate through every element past the smallest position
            for(j=i+1; j<n; ++j){
                current = (Comparable)v.elementAt(j);
                if(current.compareTo(smallest) < 0){
                    smallestPos = j;
                    smallest = current;
                }
            }
            if(smallestPos != i){
                swap(v, i, smallestPos);
            }
        }
    }
    
    /**
     * Sorts the given vector using the insertion sort algorithm
     * @param v the vector to be sorted
     * @param left used to control the sort algorithm loop
     * @param right used to control the sort algorithm loop
     */
    public static void insertionSort(MyVector v, int left, int right){
        
        int inner, outer;
        Object target;
        
        for(outer = left+1; outer <= right; ++outer){
            
            target = v.elementAt(outer);
            inner = outer;
            while(inner > left && ((Comparable)target).compareTo(v.elementAt(inner-1)) < 0){
                v.replace(inner, v.elementAt(inner-1));
                inner--;
            }
            v.replace(inner, target);
        }
    }
    
    /**
     * Obtains the median of 3 for the given vector
     * @param v the vector to be processed
     * @param left the leftmost index of the vector
     * @param right the rightmost index of the vector
     */
    public static void medianOf3(MyVector v, int left, int right){
        
        int middle = (left + right)/2;
        if(((Comparable)v.elementAt(left)).compareTo(v.elementAt(middle)) > 0){
            swap(v, left, middle);
        }
        if(((Comparable)v.elementAt(middle)).compareTo((Comparable)v.elementAt(right)) > 0){
            swap(v, middle, right);
        }
        if(((Comparable)v.elementAt(left)).compareTo(v.elementAt(middle)) > 0){
            swap(v, left, middle);
        }
    }
    
    /**
     * Partitions the given vector for the quick sort algorithm
     * @param v the vector to be partitioned
     * @param left the leftmost index of the vector
     * @param right the rightmost index of the vector
     * @return the partition index
     */
    @SuppressWarnings("empty-statement")
    public static int partition(MyVector v, int left, int right){
        
        Object pivot = v.elementAt((left+right)/2);
        
        while(true){
            while(((Comparable)v.elementAt(++left)).compareTo(pivot) < 0);
            while(((Comparable)v.elementAt(--right)).compareTo(pivot) >= 0);
            if(left > right){
                break;
            } else {
            swap(v, left, right);
            }
        }
        
        return left;
    }
    
    /**
     * Sorts the given vector using the quick sort algorithm
     * @param v the vector to be sorted
     * @param left the leftmost index of the vector
     * @param right the rightmost index of the vector
     */
    public static void quickSort(MyVector v, int left, int right){
        
        if(right - left < 10){
            insertionSort(v, left, right);
        } else {
            medianOf3(v, left, right);
            int leftPtr = partition(v, left, right);
            quickSort(v, left, leftPtr-1);
            quickSort(v, leftPtr, right);
        }
            
    }
    
    /**
     * Sorts the given vector using the merge sort algorithm
     * @param v the vector to be sorted
     * @param temp a temporary Comparable array to hold values of the vector
     * @param left the leftmost index of the vector
     * @param right the rightmost index of the vector
     */
    public static void mergeSort(MyVector v, Comparable[] temp, int left, int right){
        
        if(left == right) return;
        int middle = (left + right)/2, i, j, k;
        mergeSort(v, temp, left, middle);
        mergeSort(v, temp, middle+1, right);
        for(j=left; j<=right; ++j){
            temp[j] = (Comparable)v.elementAt(j);
        }
        i = left;
        k = middle+1;
        for(j=left; j<=right; ++j){
            if(i == middle+1){
                v.replace(j, temp[k++]);
            }
            else if(k > right){
                v.replace(j, temp[i++]);
            }
            else if(temp[i].compareTo(temp[k]) < 0){
                v.replace(j, temp[i++]);
            } 
            else {
                v.replace(j, temp[k++]);
            }
        }
    }
    
    /**
     * Swaps the elements at the given indices in the the given vector
     * @param v the target vector
     * @param first the first element of the vector to be swapped
     * @param second the second element of the vector to be swapped
     */
    public static void swap(MyVector v, int first, int second){

        Object temp = v.elementAt(first);
        v.replace(first, v.elementAt(second));
        v.replace(second, temp);
    }

    /**
     * Sorts the given vector using the shell sort algorithm
     * @param v the vector to be sorted
     */
    public static void shellSort(MyVector v){

        int inner, outer, h=1; 
        Object target; 

        while (h<=v.size())
        {
           h = 3*h+1 ;
        }
        while (h>0)
        {
           for(outer=h; outer<v.size(); ++outer)
           {
               target = v.elementAt(outer);
               inner = outer ; 
               while(inner>h-1 &&((Comparable)v.elementAt(inner-h)).compareTo(target)>0)
                       {
                          v.replace(inner, v.elementAt(inner-h));
                          inner -= h;
                       }
                   v.replace(inner, target);
           }
           h=(h-1)/3;
        }
    }


 








}
