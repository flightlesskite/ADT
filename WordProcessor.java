package assEx2018.filesForExercise;

//import classes for file input - scanner etc.
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
//import implementing set (eg. TreeSet)


public class WordProcessor {
	private static <E> String displaySet(Set<E> inputSet){
		//implement this static method to create a
		// String representation of set - 5 comma separated elements per line
		// assume that type E has a toString method
		
		@SuppressWarnings("unchecked")
		Set<CountedElement<String>> element= (Set<CountedElement<String>>) inputSet;
		Iterator<CountedElement<String>> iterator=element.iterator();
		
		String elem="";
		
		for (int i=0; i<inputSet.size(); i++)	{
			
			if (i % 5 ==0)	{
				elem+= "\n";
			}
			
			CountedElement<String> elements=iterator.next();
			elem+= "("+elements.toString()+ ", "+elements.getCount()+"), ";
		}
		
		return elem;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//	create a set of type String called wordSet
		//	create a set of type CountedElement<String> called countedWordSet 
		Set<String> wordSet= new TreeSet<String>();
		Set<CountedElement<String>> countedWordSet= new TreeSet<CountedElement<String>>();
		
		
		String []fileName= {"file0.txt", "file1.txt", "file2.txt"};
		String w[];
		
		//	for each input file (assume 3 arguments, each the name of a file)
		for (String file: fileName)	{
			try {
				String line="";
				FileReader reader= new FileReader(file);
		    		Scanner in=new Scanner(reader);
		    	
		    		while (in.hasNext())	{
		    			line=in.next();
		    			w=line.split(" ");
		    			
		    			//  for each word w
		    			for (int i=0; i<w.length; i++)	{
		    				
		    				//	if wordset doesn't contain w:
		    				if (!wordSet.contains(w[i]))	{
		    					
		    			        //	add w to wordset
		    					wordSet.add(w[i]);
		    					
		    			        //	add new element to countedWordSet
		    					CountedElement<String> s= new CountedElement<String>(w[i], 1);
		    					countedWordSet.add(s);
	    					}	
		    				
		    				//	else
		    				else	 {
		    					
		    					Iterator<CountedElement<String>> ir = countedWordSet.iterator();
		    					
		    					while (ir.hasNext())	{	
		    						CountedElement<String> elem=ir.next();
		    						
		    						//	increment numeric part of element in countedWordSet containing w
		    						if (elem.getElement().compareTo(w[i])==0)	{
		    						elem.setCount(elem.getCount()+1);
		    						}
		    					}
		    				}
		    			}
		    		}
		    		reader.close();
		    		in.close();
			}
			catch (IOException e)	{
				System.err.println("Reading from file error.");
			}
		}
		
		System.out.println(displaySet(countedWordSet));
		
//		for (CountedElement<String> f: countedWordSet)	{
//			System.out.println(f.toString());
//		}
	}


}
