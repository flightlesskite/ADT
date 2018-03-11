package assEx2018.filesForExercise;
public class CountedElement<E extends Comparable<E>> implements Comparable<CountedElement<E>> {
	private E element;
	private int count;

	public CountedElement(E e, int count){
		//constructor - to complete
		this.element=e;
		this.count=count;
	}
	
	public CountedElement(E e){
		//constructor - to complete
		this.element=e;
	}
	
	public E getElement() {
		return element;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setElement(E e)	{
		this.element=e;
	}
	
	public void setCount(int count)	{
		this.count=count;
	}

	//add getters and setters
	
	//add toString() method
	
	public String toString() {
		return this.element+"";
//		return "("+this.element+", "+this.count+"), ";
	}

	
	public int compareTo(CountedElement<E> sC1) {
		//to complete

		return this.getElement().compareTo(sC1.getElement());
	}

}
