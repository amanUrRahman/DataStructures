package strings;

public class LongestCommonSubsequence {

	static final int MAX_CHAR = 26;

	// Function to find the subsequence
	static void findSubsequence(String str, int k) {

		// Taking an extra array to keep
		// record for character count in s
		int a[] = new int[MAX_CHAR];

		// Counting occurrences of all
		// characters in str[]
		for (int i = 0; i < str.length(); i++)
			a[str.charAt(i) - 'a']++;

		// Printing characters with count
		// >= k in same order as they appear
		// in str.
		for (int i = 0; i < str.length(); i++)
			if (a[str.charAt(i) - 'a'] >= k)
				System.out.print(str.charAt(i));
	}

	// Driver code
	public static void main(String[] args) {

		int k = 2;
		findSubsequence("geeksforgeeks", k);
	}
}
