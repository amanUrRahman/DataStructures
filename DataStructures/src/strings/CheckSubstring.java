package strings;

public class CheckSubstring {
	
	
	public static int checkSubstring(String s1, String s2) {
		
		int length1 = s1.length();
		int length2 = s2.length();
		int i,j;
		
		if(length1 > length2)
			return -1;
		
		for (i = 0,j = 0; i < length1; ) {
			if (s1.charAt(i) == s2.charAt(j)) {
				i++; j++;
			}
			else {
				if (s1.charAt(0) == s2.charAt(j)) {
					i = 0;
					continue;
				}	
				j++;
				i=0;
			}	
		}
		
		if (i == s1.length())
			return 1;
		else
			return -1;	
	}
	
	
	public static void main(String args[]) {
		String s1 = "aman";
		String s2 = "mananaamaamaamamaaaaamana";
		int result = checkSubstring(s1,s2);
		if (result == -1)
			System.out.println("String 1 is not a substring");
		else
			System.out.println("String 1 is a substring");
	}
}
