package app;

import java.util.Arrays;

public class MyList<E> {
	private int size                          = 0;
	private static final int DEFAULT_CAPACITY = 10;
	private Object[] elements;

	public MyList(){
		elements = new Object[DEFAULT_CAPACITY];
	}

	public MyList(int capacity){
		elements = new Object[capacity];
	}

	public boolean add(E e){
		if (size == elements.length) {
			ensureCapacity();
		}
		elements[size++] = e;
		return true;
	}

	public void add(int index, E e){
		if (index < 0)
			return;

		if (size == elements.length && index <= size) {
			ensureCapacity();
			for (int i = elements.length-1; i > index; i--){
				elements[i] = elements[i-1];
			}
		}
		if(index > size){
			ensureCapacity(index);
		}
		elements[index] = e;
	}

	public void ensureCapacity() {
		int newSize = elements.length+1;
		ensureCapacity(newSize);
	}
	public void ensureCapacity(int index) {
		elements = Arrays.copyOf(elements, index);
	}

	/**
	 * #en: Get the object from a certain position
	 * #vi: Lấy đối tượng từ một vị trí nhất định
	 * get()
	 * @param index
	 * @return <E>
	 */
	public E get(int index){
		if (index>= size || index <0) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size );
		}
		return (E) elements[index];
	}

	public E remove(int index){
		Object nodeR = null;
		if (index < 0 || index >= size)
			return null;

		nodeR = elements[index];
		elements[index] = null;
		int countTo = size-1;
		for(int i = index; i < countTo; i++){
			elements[i] = elements[i+1];
		}
		size--;
		return (E) nodeR;
	}

	public int size(){
		return size;
	}
	public MyList<E>[] clone(){
		return (MyList<E>[]) Arrays.copyOf(elements, elements.length);
	}

	public boolean contains(E o){
		for(int i = 0; i< elements.length; i++){
			if (elements[i] == o){
				return true;
			}
		}
		return false;
	}

	public int indexOf(E o){
		for(int i = 0; i< elements.length; i++){
			if (elements[i] == o){
				return i;
			}
		}
		return -1;
	}
	public void clear(){
		for(int i = 0; i< elements.length; i++){
			elements[i] = null;
		}
		elements = new Object[0];
	}
}
