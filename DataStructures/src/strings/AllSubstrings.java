package strings;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class AllSubstrings {

	static Set<String> set = new HashSet<>();

	static void subString(String s) {
		if (s.length() == 0 || Objects.isNull(s)) {
			System.out.print("No substrings");
			return;
		}

		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j <= s.length(); j++) {
				System.out.println(s.substring(i, j));
			}
		}

	}

	public static boolean checkPalindrome(String s, int start, int end) {

		if (s.length() == 0 || Objects.isNull(s) || start >= end)
			return true;

		return (s.charAt(start) == s.charAt(end) && checkPalindrome(s, start + 1, end - 1));
	}

	// Driver code
	public static void main(String args[]) {
		String s;

		s = "ABCBAs";

		// System.out.print("\nAll possible strings are:");
		// subString(s);
		System.out.println(checkPalindrome(s, 0, s.length() - 1));

	}

}
