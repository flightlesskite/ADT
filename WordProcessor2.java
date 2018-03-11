package assEx2018.filesForExercise;

import java.util.Iterator;

public class WordProcessor2 {
	

	private static <E> String displaySet(BSTBag<CountedElement<String>> inputSet){
		//implement this static method to create a
		// String representation of set - 5 comma separated elements per line
		// assume that type E has a toString method
		
		String elem="";
		Iterator<CountedElement<String>> iter=inputSet.iterator();
			
		
		for (int i=0; i<inputSet.size(); i++)	{
			CountedElement<String> element=iter.next();
			
			elem+= "("+element+", "+element.getCount()+"), ";
//			elem+= "("+element+"), ";
			
		}
		
		return elem;
	}
	
	
	public static void main(String[] args) {
		BSTBag<CountedElement<String>> bag1= new BSTBag<CountedElement<String>>();
		
		CountedElement<String> s= new CountedElement<String>("Fish");
		CountedElement<String> t= new CountedElement<String>("Dog");
		
		CountedElement<String> u= new CountedElement<String>("Cat");
		CountedElement<String> p= new CountedElement<String>("Cow");
		CountedElement<String> i= new CountedElement<String>("Duck");
		CountedElement<String> d= new CountedElement<String>("Ant");
		
		bag1.add(s);
		bag1.add(s);
		
		bag1.add(s);
		
		bag1.add(u);
		
		bag1.add(s);
		bag1.add(p);
		bag1.add(p);
		bag1.add(i);

		bag1.add(u);
//		
		
		bag1.remove(p);
		bag1.remove(i);

	
//		bag1.remove(u);
		

		System.out.println("There are "+ bag1.size()+" items in the bag");
		
		System.out.println ("it is...."+bag1.contains(p));
		
		System.out.println ("it is...."+bag1.contains(u));
		
		
		System.out.println(displaySet(bag1));

	}
	
	

}
