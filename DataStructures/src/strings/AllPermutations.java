package strings;

import java.util.HashSet;
import java.util.Set;

public class AllPermutations {
	static void permuteDistinct(String s, String answer, Set<String> set) {
		if (s.length() == 0) {
			set.add(answer);
			return;
		}

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			String left_substr = s.substring(0, i);
			String right_substr = s.substring(i + 1);
			String rest = left_substr + right_substr;
			permuteDistinct(rest, answer + ch, set);
		}
	}
	
	
	public static void permute(String s, String answer) {
		Set<String> set = new HashSet<>();
		permuteDistinct(s,answer,set);
		for (String str: set) {
			System.out.print(str + " ");
		}
	}

	// Driver code
	public static void main(String args[])
	{
	    String s;
	    String answer="";
	   
	     
	    s = "SABA";
	    permute(s,answer);
	    
		/*
		 * Map<String, List<Integer>> variable = new HashMap<>(); List<Integer> list =
		 * new ArrayList<>(Arrays.asList(1,2,3)); variable.put("aman", list);
		 * System.out.println(variable); variable.get("aman").add(4);
		 * System.out.println(variable);
		 */
	    
	    
	    //System.out.println((int)Math.sqrt(7));
	    //System.out.print("\nAll possible strings are : ");
	    //permute(s, answer);
	}
}
