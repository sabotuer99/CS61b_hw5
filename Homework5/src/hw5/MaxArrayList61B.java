package hw5;

public class MaxArrayList61B<T extends Comparable<T>> extends ArrayList61B<T> {
	T currentMax;
	
	public MaxArrayList61B() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public MaxArrayList61B(int initialCapacity){
		super(initialCapacity);
	}
	
	@Override
	public boolean add(T item){
		if((currentMax != null && item.compareTo(currentMax) <= 0) || item == null){
			return false;
		}
		currentMax = item;
		return super.add(item);
	}
}
