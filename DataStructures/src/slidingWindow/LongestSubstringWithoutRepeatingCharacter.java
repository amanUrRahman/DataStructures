package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacter {

	public static int longestSubstringWithoutRepeatingCharacters(String text) {

		int i = 0, j = 0, longestSubstring = 0;
		Map<Character, Integer> map = new HashMap<>();

		while (j < text.length()) {

			if (map.containsKey(text.charAt(j))) {
				map.put(text.charAt(i), map.get(text.charAt(i)) - 1);
				if (map.get(text.charAt(i)) == 0)
					map.remove(text.charAt(i));
				i++;

			} else {
				map.put(text.charAt(j), 1);
				if (j - i + 1 > longestSubstring)
					longestSubstring = j - i + 1;
				j++;
			}
		}
		return longestSubstring;
	}

	public static void main(String[] args) {
		String text = "pwwkew";
		System.out.println(longestSubstringWithoutRepeatingCharacters(text));

	}

}
