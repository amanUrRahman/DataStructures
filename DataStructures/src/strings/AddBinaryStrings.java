package strings;

public class AddBinaryStrings {
	
	public static void addBinaryStrings(String str1, String str2) {
		
		int i = str1.length()-1, j = str2.length()-1;
		StringBuffer sb = new StringBuffer(Math.max(str1.length(), str2.length())+1);
		int carry = 0, add = 0;
		
		while (i>=0 && j>=0) {
			if (str1.charAt(i) - '0' + str2.charAt(j) - '0' + carry == 0) {
				carry = 0;
				add = 0;
			}
			else if (str1.charAt(i) - '0' + str2.charAt(j) - '0' + carry == 1) {
				carry = 0;
				add = 1;
			}
			else if (str1.charAt(i) - '0' + str2.charAt(j) - '0' + carry == 2) {
				carry = 1;
				add = 0;
			}
			else if (str1.charAt(i) - '0' + str2.charAt(j) - '0' + carry == 3) {
				carry = 1;
				add = 1;
			}
			sb.append(add);	i--;j--;
		}
		
		while (i >= 0) {
			if (str1.charAt(i) - '0' + carry == 0) {
				carry = 0;
				add = 0;
			}
			else if (str1.charAt(i) - '0' + str2.charAt(j) - '0' + carry == 1) {
				carry = 0;
				add = 1;
			}
			else if (str1.charAt(i) - '0' + str2.charAt(j) - '0' + carry == 2) {
				carry = 1;
				add = 0;
			}
			sb.append(add);	i--;
		}
		
		while (j >= 0) {
			if (str2.charAt(j) - '0' + carry == 0) {
				carry = 0;
				add = 0;
			}
			else if (str2.charAt(j) - '0' + carry == 1) {
				carry = 0;
				add = 1;
			}
			else if (str2.charAt(j) - '0' + carry == 2) {
				carry = 1;
				add = 0;
			}
			sb.append(add); j--;
		}
		
		sb.append(carry);
			
		System.out.println(sb.reverse());
		
		
		
		
		
	}
	

	public static void main(String[] args) {
		String str1 = "11";
		String str2 = "111";
		addBinaryStrings(str1,str2);

	}

}
