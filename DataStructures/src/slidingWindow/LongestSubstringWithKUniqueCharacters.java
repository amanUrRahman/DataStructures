package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueCharacters {

	public static int longestUniqueChar(char array[], int unique) {

		int i = 0, j = 0, longestSubstring = 0;
		Map<Character, Integer> map = new HashMap<>();

		while (j < array.length) {

			if (map.containsKey(array[j])) {
				map.put(array[j], map.get(array[j]) + 1);
			} else
				map.put(array[j], 1);

			if (map.size() < unique) {
				j++;

			} else if (map.size() == unique) {
				if (j - i + 1 > longestSubstring)
					longestSubstring = j - i + 1;
				j++;

			} else if (map.size() > unique) {
				map.put(array[i], map.get(array[i]) - 1);
				if (map.get(array[i]) == 0)
					map.remove(array[i]);
				i++;
			}
		}
		return longestSubstring;
	}

	public static void main(String[] args) {
		char[] array = { 'a', 'a', 'b', 'a', 'c', 'b', 'e', 'b', 'e', 'b', 'e' };
		int unique = 3;
		System.out.println(longestUniqueChar(array, unique));

	}

}
