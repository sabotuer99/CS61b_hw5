package hw5;

import java.util.AbstractList;

public class ArrayList61B<E> extends AbstractList<E>  {

	private Object[] items = new Object[1];
	private int itemCount = 0;
	
	public ArrayList61B(){
	}
	
	public ArrayList61B(int initialCapacity) {
		if(initialCapacity <= 0)
			throw new IllegalArgumentException();
		items = new Object[initialCapacity];
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int arg0) {
		// TODO Auto-generated method stub
		if(arg0 < 0 || arg0 >= itemCount)
			throw new IllegalArgumentException();
		
		return (E)items[arg0];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return itemCount;
	}
	
	public boolean add(E item){
		//if items is full, double size
		if(itemCount == items.length){
			Object[] bigger = new Object[items.length * 2];
			for(int i = 0; i < items.length; i += 1 ){
				bigger[i] = items[i];
			}
			items = bigger;
			//System.out.println("Doubled Array Size!");
		}
		
		items[itemCount] = item;
		itemCount += 1;
		return true;
	}

}
