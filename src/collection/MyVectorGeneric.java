/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 *
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 */
public class MyVectorGeneric <T extends Comparable<T>> implements Cloneable{
    
    private static final int INITIAL_CAPACITY = 100;
    private Object[] data;
    private int size;
    
    public MyVectorGeneric(){
        data = new Object[INITIAL_CAPACITY];
        size = 0;
    }
    
    public void append(T element){
        if(size == data.length)
            expand();
        
        data[size] = element;
        ++size;
    }
    
    public void expand(){
        Object[] temp = new Object[data.length * 2];
        
        for(int i=0; i<size; ++i){
            temp[i] = data[i];
        }
        
        data = temp;
    }
    
    public boolean contains(T element){
        for(int i=0; i<size; ++i){
            if(data[i].equals(element)){
                return true;
            }
        }
        return false;
    }
    
    public T elementAt(int index){
        if(index < 0 || index >= size) return null;  
        return (T)data[index];
    }
    
    public int indexOf(T element){
        for(int i=0; i<size; ++i){
            if(data[i].equals(element)){
                return i;
            }
        }
        return -1;
    }
    
    public boolean insertAt(int index, T element){
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
    
    public T removeAt(int index){
        if(index < 0 || index >= size){
            return null;
        }
        T temp = (T)data[index];
        
        while(index < size-1){
            data[index] = data[index+1];
            ++index;
        }
        data[--size] = null;
        return temp;
    }
    
    public boolean isEmpty(){
        for(int i=0; i<size; ++i){
            if(data[i] != null){
                return false;
            }
        }
        return true;
    }
    
    public void clear(){
        for(int i=0; i<size; ++i){
            data[i] = null;
            --size;
        }
    }
    
    public boolean remove(T element){
        return removeAt(indexOf(element)) != null;
    }
    
    public boolean replace(int index, T element){
        if(index < 0 || index >= size){
            return false;
        }
        data[index] = element;
        return true;
    }
    
    public int size(){
        return size;
    }
    
    public void ensureCapacity(int minCapacity){
        
        if(minCapacity <= data.length)
            return;
        Object[] newData = new Object[minCapacity];
        for(int i=0; i<size; ++i){
            newData[i] = data[i];
        }
        data = newData;
    }
    
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
    
    public void reverse(){
        
        Object temp;
        
        for(int i=0; i<(size/2); ++i){
            temp = data[i];
            data[i] = data[size-i-1];
            data[size-i-1] = temp;
        }
    }
    
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
    
    public void merge(MyVectorGeneric v){
        ensureCapacity(this.size + v.size);
        for(int i=0; i<v.size; ++i){
            append((T)v.data[i]);
        }
    }
    
    @Override
    public MyVectorGeneric<T> clone(){
        
        MyVectorGeneric<T> vecCopy = new MyVectorGeneric<>();
        vecCopy.ensureCapacity(this.size);
        
        for(int i=0; i<size; ++i){
            vecCopy.data[i] = this.data[i];
        }
        vecCopy.size = this.size;
        return vecCopy;
    }
}
