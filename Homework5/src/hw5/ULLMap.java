package hw5;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set; /* java.util.Set needed only for challenge problem. */


/** A data structure that uses a linked list to store pairs of keys and values.
 *  Any key must appear at most once in the dictionary, but values may appear multiple
 *  times. Supports get(key), put(key, value), and contains(key) methods. The value
 *  associated to a key is the value in the last call to put with that key. 
 *
 *  For simplicity, you may assume that nobody ever inserts a null key or value
 *  into your map.
 */ 
public class ULLMap<K, V> implements Map61B<K, V>, Iterable<K>{ //FIX ME
    /** Keys and values are stored in a linked list of Entry objects.
      * This variable stores the first pair in this linked list. You may
      * point this at a sentinel node, or use it as a the actual front item
      * of the linked list. 
      */
    private Entry<K, V> front;

    @Override
    public V get(K key) { //FIX ME
    	Entry<K, V> node =  front.get(key);
    	V result;
    	if(node == null)
    		result = null;
    	else
    		result = node.val;
        return result; //FIX ME
    }

    @Override
    public void put(K key, V val) { //FIX ME
    	if(!containsKey(key)){
    		Entry<K, V> insertion = new Entry<K, V>(key, val, front);
    		front = insertion;
    	}
    		
    }

    @Override
    public boolean containsKey(K key) { 
    	if(front == null || front.get(key) == null)
    		return false; 
    	else
    		return true;
    }

    @Override
    public int size() {
    	if(front == null)
    		return 0;
    	int count = 0;
    	Entry<K,V> current = front;
    	while(current!=null){
    		count += 1;
    		current = current.next;
    	}
    	
        return count; // FIX ME (you can add extra instance variables if you want)
    }

    @Override
    public void clear() {
    	front = null;
    }


    /** Represents one node in the linked list that stores the key-value pairs
     *  in the dictionary. */
    private class Entry<K, V> {
    
        /** Stores KEY as the key in this key-value pair, VAL as the value, and
         *  NEXT as the next node in the linked list. */
        public Entry(K k, V v, Entry<K, V> n) { //FIX ME
            key = k;
            val = v;
            next = n;
        }

        /** Returns the Entry in this linked list of key-value pairs whose key
         *  is equal to KEY, or null if no such Entry exists. */
        public Entry<K, V> get(K k) { //FIX ME
            //FILL ME IN (using equals, not ==)
        	Entry<K, V> result;
        	if(!key.equals(k)){
        		if(next == null)
        			result = null;
        		else
        		result = next.get(k);
        	} else {
        		result = this;
        	}
        	return result; //FIX ME
        }

        /** Stores the key of the key-value pair of this node in the list. */
        private K key; //FIX ME
        /** Stores the value of the key-value pair of this node in the list. */
        private V val; //FIX ME
        /** Stores the next Entry in the linked list. */
        private Entry<K, V> next;
    
    }

    /* Methods below are all challenge problems. Will not be graded in any way. 
     * Autograder will not test these. */
    @Override
    public V remove(K key) { //FIX ME SO I COMPILE
    	if(front == null)
    		return null;
    	
    	if(key.equals(front.key)){
    		V value = front.val;
    		front = front.next;
    		return value;
    	}
    	
    	Entry<K, V> current = front;
    	while(current.next != null){
    		if(key.equals(current.next.key)){
    			V value = current.next.val;
    			current.next = current.next.next;
    			return value;
    		}
    		current = current.next;
    	}
    	return null;
    }

    @Override
    public V remove(K key, V value) { //FIX ME SO I COMPILE
    	if(front == null)
    		return null;
    	
    	if(key.equals(front.key) && value.equals(front.val)){
    		front = front.next;
    		return value;
    	}
    	
    	Entry<K, V> current = front;
    	while(current.next != null){
    		if(key.equals(current.next.key) && value.equals(current.next.val)){
    			current.next = current.next.next;
    			return value;
    		}
    		current = current.next;
    	}
    	return null;
    }

    @Override
    public Set<K> keySet() { //FIX ME SO I COMPILE
    	if(front == null)
    		return null;
    	Set<K> keys = new HashSet<K>();
    	Entry<K, V> current = front;
    	while(current != null){
    		keys.add(current.key);
    		current = current.next;
    	}
    	return keys;
    }

	@Override
	public Iterator<K> iterator() {
		// TODO Auto-generated method stub
		return new ULLMapIter();
	}

	private class ULLMapIter implements Iterator<K>{

		Entry<K, V> current = front;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public K next() {
			// TODO Auto-generated method stub
			if(current == null)
				throw new NoSuchElementException();
			
			K value = current.key;			
			current = current.next;
			return value;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException();
		}
		
	}
	
	public static <T2, T1> ULLMap<T2, T1> invert(ULLMap<T1, T2> original){
		ULLMap<T2, T1> inverted = new ULLMap<T2, T1>();
		Iterator<T1> iterator = original.iterator();
		while(iterator.hasNext()){
			T1 key = iterator.next();
			T2 val = original.get(key);
			inverted.put(val, key);					
		}	
		return inverted;
	}

}