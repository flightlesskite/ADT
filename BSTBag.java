package assEx2018.filesForExercise;

import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("rawtypes")
public class BSTBag<E extends Comparable<E>> implements Bag<E> {
	
	BSTNode<E> root;
	BSTNode<E> last;
	int size;
	
	public BSTBag()	{
		root=null;
		size=0;
	}
	
	// //////// Inner class //////////
		private static class BSTNode<E extends Comparable<E>> {
			protected CountedElement<E> element;
			protected BSTNode<E> left, right;
			protected int count;
			
			protected BSTNode(E elem) {
				element = new CountedElement<E>(elem);
				left = null;
				right = null;
				count=1;
			}
			
			public boolean contains(E elem)	{
				CountedElement<E> other= new CountedElement<E>(elem);
				int comp= other.compareTo(element);
				if(comp ==0 && count>0)
					return true;
				if(comp <0 && left!= null && left.contains(elem))
					return true;
				if(comp >0 && right!= null && right.contains(elem))
					return true;
				return false;
			}
		

		}

	public boolean isEmpty() {
		return (root==null);
	}


	public int size() {
		return size;
	}

	public boolean contains(E element) {
		
		
		if (root== null)
			return false;
		return root.contains(element);
		
	}

	public boolean equals(Bag that) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		root=null;
	}

	
	public void add(E element) {
		int direction=0;
		BSTNode<E> parent=null;
		BSTNode<E> curr=root;
		size++;
		
		
		for (;;) {
			if (curr== null) {
				BSTNode<E> add= new BSTNode<E>(element);
				add.element.setCount(add.count);
		
				if (root == null)	{
					root= add;
				}
				else if (direction <0)
					parent.left=add;
				else 
					parent.right=add;
				return;
			}
			
			CountedElement<E> elem= new CountedElement<E> (element);
			direction= elem.compareTo(curr.element);
			
			if (direction ==0) {
				// if already existing increment count
				// set count of CountedElement
				curr.count++;
				curr.element.setCount(curr.count);
				return;
			}
			parent=curr;
			
			if (direction <0)
				curr= curr.left;
			
			else
				curr=curr.right;
		}
		
		
	}

	public void remove(E element) {
		int direction= 0;
		BSTNode<E> curr=root;
		size--;
		
		for(;;)	{
			if (curr== null) 
				return;
			
			CountedElement<E> elem= new CountedElement<E> (element);
			direction= elem.compareTo(curr.element);
			
			if (direction == 0) {
				curr.count--;
				curr.element.setCount(curr.count);
				return;
			}
			
			if (direction <0)
				curr= curr.left;
			else
				// direction >0
				curr= curr.right;
		}
		
	}
	

	@Override
	public Iterator<E> iterator() {		
		return new InOrderIter();
	}
	
	private class InOrderIter implements Iterator<E>	{
		LinkedStack<BSTNode<E>> stack;
		
		private InOrderIter()	{
			stack=  new LinkedStack<BSTNode<E>> ();
			
			for (BSTNode<E> curr= root; curr!= null; curr=curr.left)	{
				for (int i=0; i<curr.count; i++)	{
					stack.push(curr);
//					System.out.println(stack.peek().element);
				}
			}
		}
		
		public boolean hasNext()	{
			return (!stack.empty());
		}
		
		
		public E next()	{
			if (stack.empty())
				throw new NoSuchElementException();
			BSTNode<E> place= stack.pop();
//			System.out.println(stack.peek().element);
//			System.out.println(place.element);
			for	(BSTNode<E> curr= place.right; curr!=null; curr= curr.left)	{
				
				while (curr.count>0)	{
				stack.push(curr);
				curr.count--;
				
				}
			}
			return (E) place.element;
		}
		
		
		
	}




}
