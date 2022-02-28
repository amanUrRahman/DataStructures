package arrays;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class IncreasingSubsetMaxProduct {
	
	static int maxProd = 0;
	
	static void check(List<Integer> a) {
		
		if (a.get(0) < a.get(1) && a.get(1) < a.get(2)) {
			if (a.get(0)*a.get(1)*a.get(2) > maxProd)
				maxProd = a.get(0)*a.get(1)*a.get(2);
		}
		
		
		
	}
	
	static void subSet(List<Integer> a, List<Integer> answer)
	{  
		
		List<Integer> adummy = new ArrayList<>(a);
		List<Integer> answerdummy = new ArrayList<>(answer);
		
	    if (answerdummy.size() == 3)
	    {
	    	check(answerdummy);
	        return;
	    }
	   
	    int s1;
	    if (adummy.size()!=0) {
	    	s1 = adummy.get(0);
	    	adummy.remove(0);
	    }
	    else 
	    	return;
	    
	    
	    subSet(adummy, answerdummy);
	    answerdummy.add(s1);
	    subSet(adummy, answerdummy);
	    
	   
	}
	 
	// Driver code
	public static void main(String args[]) throws InterruptedException
	{
	    int arr[] = {6,7,8,1,2,3,9,10};
	    List<Integer> al = new ArrayList<>();
	    List<Integer> answer = new ArrayList<>();
	    for (int a: arr) {
	    	al.add(a);
	    }
	    Instant start = Instant.now();
	    subSet(al, answer);
	    Instant end = Instant.now();
	    System.out.println(maxProd);
	    //System.out.println(Duration.between(start, end).toMillis());
	}

}
