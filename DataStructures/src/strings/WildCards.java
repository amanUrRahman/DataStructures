package strings;

public class WildCards {
	
	public static boolean checkWildCardWithindices(String string, String wildcard, int i, int j) {
		
		if (i==string.length() && j==wildcard.length())
			return true;
		
		if (i==string.length() || j==wildcard.length())
			return false;
		
		if (string.charAt(i) == wildcard.charAt(j) || wildcard.charAt(j) == '?')
			return checkWildCardWithindices(string,wildcard,i+1,j+1);
		
		if (wildcard.charAt(j) == '*')
			return (checkWildCardWithindices(string,wildcard,i+1,j+1) || checkWildCardWithindices(string,wildcard,i+1,j));
		
		return false;
		
	}
	
	
	
	public static boolean checkWildCard(String string, String wildcard) {
		int i=0,j=0;
		return checkWildCardWithindices(string,wildcard,i,j);
	}

	public static void main(String[] args) {
		String str = "saba";
		String wildcard = "s*";
		System.out.println(checkWildCard(str,wildcard));

	}

}
