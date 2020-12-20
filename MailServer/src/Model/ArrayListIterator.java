package Model;

import java.util.ArrayList;

public class ArrayListIterator implements Iterator{
	private ArrayList<Object> iterableList;
	
	// position of next object to pick
	private static int position = 0; 
	
	public ArrayListIterator(Object iterableList) {
		this.iterableList = (ArrayList<Object>) iterableList;
	}

	@Override
	public boolean hasNext() {
		if (position >= iterableList.size())
			return false;
		return true;
	}

	@Override
	public Object next() {
		return iterableList.get(position++);
	}
	
	
	

}
