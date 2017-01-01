
package collection;

/**
 * Implements all the methods of the MyVector class as defined
 * in the instructions for COSC 241 Lab 2
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻ Tripp (╯°□°）╯︵ ┻━┻
 * @version 1.0
 */
public class MyVector implements Cloneable{
    
    private Object[] data;
    private static final int INITIAL_CAPACITY = 100;
    private int size;
    
    public MyVector(){
        data = new Object[INITIAL_CAPACITY];
        size = 0;
    }
    
    /**
     * Adds the specified Object to the end of the specified vector.
     * @param element the object to be added to the vector
     */
    public void append(Object element){
        
        if(size == data.length)
            expand();
        
        data[size] = element;
        ++size;
    }
    
    /**
     * Clears the specified vector, setting all elements to 'null'.
     */
    public void clear(){
        
        for(int i=0; i<size; ++i){
            data[i] = null;
            --size;
        }
    }
    
    /**
     * Determines whether the specified Object is contained in the vector.
     * @param element the Object to search for
     * @return true if element is in the vector, false otherwise.
     */
    public boolean contains(Object element){
        
        for(int i=0; i<size; ++i){
            if(data[i].equals(element)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Locates and returns the element at the specified vector, if one exists.
     * @param index the index of the Object to locate.
     * @return the Object if found, 'null' if not found.
     */
    public Object elementAt(int index){
        if(index < 0 || index >= size){
            return null;
        }   
        return data[index];
    }
    
    /**
     * Locates and returns the index of the specified Object, if it exists in
     * the vector.
     * @param element the Object to locate
     * @return the index of the Object if it is in the vector, -1 otherwise.
     */
    public int indexOf(Object element){
        for(int i=0; i<size; ++i){
            if(data[i].equals(element)){
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Inserts the specified Object at the specified index if possible.
     * @param index the index to store the Object at
     * @param element the Object to be stored
     * @return true if the element is successfully stored, false otherwise
     */
    public boolean insertAt(int index, Object element){
        
        if(index < 0 || index >= size){
            return false;
        }
        if(size == data.length){
            expand();
        }
        
        for(int i = size; i > index; i--){
            data[i] = data[i-1];
        }
        
        data[index] = element;
        size++;
        return true;
    }
    
    /**
     * Determines whether the vector is empty
     * @return true if the vector is empty, false if it is not
     */
    public boolean isEmpty(){
        
        for(int i=0; i<size; ++i){
            if(data[i] != null){
                return false;
            }
        }
        return true;
    }
    
    /**
     * Removes the object at the specified index, if one exists there.
     * @param index the index of the Object to be removed
     * @return the Object that was removed or 'null' if one was not found
     */
    public Object removeAt(int index){
        
        if(index < 0 || index >= size){
            return null;
        }
        Object temp = data[index];
        
        while(index < size-1){
            data[index] = data[index+1];
            ++index;
        }
        data[--size] = null;
        return temp;
    }
    
    /**
     * Removes the specified Object from the vector
     * @param element the Object to be removed
     * @return true if the Object was removed, false if it was not
     */
    public boolean remove(Object element){
        
        return removeAt(indexOf(element)) != null;
    }
    
    /**
     * Replaces the Object at the specified index with the specified Object.
     * @param index the index of the Object to be replaced
     * @param element the Object to replace the existing Object
     * @return true if the Object was replaced, false if it was not
     */
    public boolean replace(int index, Object element){
        
        if(index < 0 || index >= size){
            return false;
        }
        data[index] = element;
        return true;
    }
    
    /**
     * Returns the size of the vector
     * @return the size of the vector
     */
    public int size(){
        return size;
    }
    
    /**
     * Expands the size of the vector to meet the specified capacity
     * @param minCapacity the new capacity of the vector
     */
    public void ensureCapacity(int minCapacity){
        
        if(minCapacity <= data.length)
            return;
        Object[] newData = new Object[minCapacity];
        for(int i=0; i<size; ++i){
            newData[i] = data[i];
        }
        data = newData;
    }
    
    /**
     *Creates a copy of the vector
     * @return the cloned vector as a new MyVector object
     */
    @Override
    public MyVector clone(){
        
        MyVector vecCopy = new MyVector();
        vecCopy.ensureCapacity(this.size);
        
        for(int i=0; i<size; ++i){
            vecCopy.data[i] = this.data[i];
        }
        vecCopy.size = this.size;
        return vecCopy;
    }
    
    /**
     * Removes elements in the vector from the specified start index (inclusive) to the 
     * specified end index (exclusive)
     * @param fromIndex the starting index of the range to be removed
     * @param toIndex the end index of the range to be removed
     */
    public void removeRange(int fromIndex, int toIndex){
        
        if(fromIndex >= toIndex) return;
        
        if(fromIndex < 0) fromIndex = 0;
        
        if(toIndex > size) toIndex = size;
        
        int num = toIndex - fromIndex;
        
        for(int i=fromIndex; i<size-num; ++i){
            data[i] = data[i+num];
        }
        for(int j=size-num; j<size; ++j){
            data[j] = null;
        }
        size = size-num;
    }
    
    /**
     * Creates a String representation of the properties and elements of the 
     * MyVector class
     * @return the generated String representation of the MyVector class
     */
    @Override
    public String toString(){
        
        String str = "------------------------------------------\n" + 
               "The current vector contains the following:\n";
        
        str += "Size = " + size + "\n";
        str += "Allowed Capacity = " + data.length + "\n";
        for(int i=0; i<size; ++i){
            str+= i + ": " + data[i] + "\t";
            if((i+1)%5 == 0){
                str += "\n";
            }
        }
        str += "\n-----------------------------------------\n";
        return str;
    }
    
    /**
     * Reverses the elements of the vector
     */
    public void reverse(){
        
        Object temp;
        
        for(int i=0; i<(size/2); ++i){
            temp = data[i];
            data[i] = data[size-i-1];
            data[size-i-1] = temp;
        }
    }
    
    /**
     * Increases the capacity of the vector to twice its current capacity
     */
    public void expand(){
        
        Object[] temp = new Object[data.length * 2];
        
        for(int i=0; i<size; ++i){
            temp[i] = data[i];
        }
        
        data = temp;
    }
    
    /**
     * Merges the parameter MyVector object with the vector
     * @param v the MyVector object to merge with the vector
     */
    public void merge(MyVector v){
        ensureCapacity(this.size + v.size);
        for(int i=0; i<v.size; ++i){
            append(v.data[i]);
        }
    }
}
