package strings;

import java.util.Objects;

public class PrintXFormat {

	public static void printXFormat(String str) {
		
		if (str.length()==0 || Objects.isNull(str))
			return;
		
		if (str.length() == 1)
			System.out.println(str);
		
		int k = str.length();
		
		for (int i = 0; i < str.length(); i++) {
			for (int j=0; j < str.length(); j++) {
				if (j==i && i==k-1) {
					System.out.print(str.charAt(i));
					break;
				}
			    else if (j==i)
					System.out.print(str.charAt(i));
				else if (j==k-1) {
					System.out.print(str.charAt(k-1));
					k--;		
				}
				else if (j!=i && j!=k)
					System.out.print(" ");
			}
			System.out.println();
		}
		
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		String str = "geeksforgeeks";
		printXFormat(str);
	}

}
