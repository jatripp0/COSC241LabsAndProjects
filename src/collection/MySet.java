package collection;

/**
 *Implements all the methods of the MySet class as defined
 * in the instructions for COSC 241 Project 1
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻ Tripp (╯°□°）╯︵ ┻━┻
 * @version 1.0
 */
public class MySet extends MyVector{
    
    /**
     * Gets the cardinality, or size, of the set.
     * @return the number of elements in the set
     */
    public int cardinality(){
        return this.size();
    }
    
    /**
     * Subtracts the parameter set from the reference set and
     * returns the resulting set.
     * @param B the set to be subtracted from the reference set
     * @return the resulting set from subtracting B from the reference set
     */
    public MySet complement(MySet B){
        
        MySet comp = new MySet();
        
        for(int i=0; i<size(); ++i){
           /*
            Inserts the element at i into the complement set only if 
            set B does not contain that element.
            */
           if(!B.contains(elementAt(i))){
               comp.insert(elementAt(i));
           }
        }
        return comp;
    }
    
    /**
     * Inserts the given element into the set
     * (excludes duplicate elements).
     * @param element the element to be inserted into the set
     */
    public void insert(Object element){
        /*
        Inserts the given element only if the set does not
        already contain that element.
        */
        if(!this.contains(element)){
            append(element);
        }
    }
    
    /**
     * Calculates and returns the intersection set of the
     * reference set and the parameter set.
     * @param B the set to be compared with the reference set
     * @return the resulting intersection set
     */
    public MySet intersection(MySet B){
        
        MySet inter = new MySet();
        
        for(int i=0; i<size(); ++i){
            /*
            Inserts the element at i in the set into the intersection set
            only if set B contains that element.
            */
            if(B.contains(elementAt(i))){
                inter.insert(elementAt(i));
            }
        }
        return inter;
    }
    
    /**
     * Determines if the parameter set is a subset of the
     * reference set and returns the result.
     * @param B the superset to be compared against
     * @return true if the reference set is a subset of the parameter set, false
     *  if not
     */
    public boolean subsetOf(MySet B){
        for(int i=0; i<size(); ++i){
            /*
            Returns false if any element in the reference set is
            not contained in set B. All elements of the reference 
            set must be present in set B for the reference set to 
            be a subset of B.
            */
            if(!B.contains(elementAt(i)))
                return false;
        }
        //Returns true if all elements of the reference set are also in set B.
        return true;
    }
    
    /**
     * Calculates and returns the symmetric difference set
     * of the reference set and the parameter set.
     * @param B the parameter set to be compared with the reference set
     * @return the resulting symmetric difference set
     */
    public MySet symmetricDifference(MySet B){
        //(this set - B)
        MySet set1 = complement(B);
        //(B - this set)
        MySet set2 = B.complement(this);
        //(this set - B) U (B - this set)
        return set1.union(set2);
    }
    
    /**
     * Calculates and returns the union set of the reference set
     * and the parameter set.
     * @param B the parameter set to be compared with the reference set
     * @return the resulting union set
     */
    public MySet union(MySet B){
        
        MySet u = new MySet();
        //Inserts all elements of the reference set into the union set.
        for(int i=0; i<size(); ++i){
            u.insert(this.elementAt(i));
        }
        /*
        Inserts all elements of set B into the union set,
        excluding any elements that have already been inserted
        into the union set.
        */
        for(int j=0; j<B.size(); ++j){
            u.insert(B.elementAt(j));
        }
        
        return u;
    }
    
    /**
     * Returns a copy of the MySet object
     * @return the clone of the set
     */
    @Override
    public MySet clone(){
      
        MySet c = new MySet();
        c.ensureCapacity(this.size());
        //Inserts every element of the reference set into the clone set.
        for(int i=0; i<size(); ++i){
            c.insert(elementAt(i));
        }
        
        return c;
    }
    
    /**
     * Creates and returns a string describing the elements
     * and cardinality of the set.
     * @return the resulting string
     */
    @Override
    public String toString(){
        
        String str = "This set contains the following elements:\n\n{ ";
        
        for(int i=0; i<size(); ++i){
            str+= elementAt(i);
            if(i != size()-1){
                str+= ", ";
            }
            if((i+1) % 17 == 0){
                str+= "\n";
            }
        }
        str+= "}\n\nCardinality of the set: " + cardinality() + "\n\n";
        
        return str;
    }
}
