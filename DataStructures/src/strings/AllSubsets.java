package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllSubsets {
	
	static Set<String> set = new HashSet<>();
	
	static void subSet(String s , String answer)
	{  
	    if (s.length() == 0)
	    {
	    	set.add(answer);
	        //System.out.print(answer + "  ");
	        return;
	    }
	   
	    String s1 = "";
	    char s2 = s.charAt(0);
	    subSet(s.substring(1), answer+s2);
	    subSet(s.substring(1), answer);
	    
	   
	}
	 
	// Driver code
	public static void main(String args[])
	{
	    String s;
	    String answer="";
	     
	    s = "ABC";
	     
	    System.out.print("\nAll possible strings are : ");
	    subSet(s, answer);
	    List<String> list = new ArrayList<String>(set);
	    Collections.sort(list);
	    System.out.print(list);
	}

}
