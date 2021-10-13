package slidingWindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumWindowSubstring {

	public static boolean sameCount(Map<Character, Integer> compareMap, Map<Character, Integer> wordMap) {
		boolean flag = false;

		for (Character ch : compareMap.keySet()) {
			if (compareMap.get(ch) != wordMap.get(ch)) {
				flag = true;
			}
		}
		return flag;
	}

	public static int mimumWindowSubstring(String text, String word) {

		int i = 0, j = 0;
		Map<Character, Integer> wordMap = new HashMap<>();
		Set<Integer> set = new HashSet<>();

		for (Character ch : word.toCharArray()) {
			if (wordMap.containsKey(ch))
				wordMap.put(ch, wordMap.get(ch) + 1);
			else
				wordMap.put(ch, 1);
		}

		while (j < text.length()) {

			if (wordMap.containsKey(text.charAt(j))) {
				wordMap.put(text.charAt(j), wordMap.get(text.charAt(j)) - 1);
			}

			if (wordMap.values().stream().allMatch(e -> e == 0)) {

				while (wordMap.values().stream().allMatch(e -> e == 0)) {
					set.add(j - i + 1);
					if (wordMap.containsKey(text.charAt(i))) {
						wordMap.put(text.charAt(i), wordMap.get(text.charAt(i)) + 1);
					}
					i++;

				}
			}

			if (wordMap.values().stream().anyMatch(e -> e < 0)) {

				while (wordMap.values().stream().anyMatch(e -> e < 0)) {
					if (wordMap.containsKey(text.charAt(i))) {
						wordMap.put(text.charAt(i), wordMap.get(text.charAt(i)) + 1);
					}
					i++;
				}
			}

			j++;

		}

		return Collections.min(set);
	}

	public static void main(String[] args) {
		String text = "ADOBECODEBANC";
		String word = "ABC";
		System.out.println(mimumWindowSubstring(text, word));

	}

}
