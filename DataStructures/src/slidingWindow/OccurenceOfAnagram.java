package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class OccurenceOfAnagram {

	public static int occurenceOfAnagram(String text, String word) {

		int i = 0, j = 0, occurences = 0;
		Map<Character, Integer> wordMap = new HashMap<>();
		int wordLength = word.length();
		int textLength = text.length();

		for (int k = 0; k < word.length(); k++) {
			if (wordMap.containsKey(word.charAt(k))) {
				wordMap.put(word.charAt(k), wordMap.get(word.charAt(k)) + 1);
			} else {
				wordMap.put(word.charAt(k), 1);
			}
		}

		while (j < textLength) {

			if (j - i + 1 < wordLength) {
				if (wordMap.containsKey(text.charAt(j)) && wordMap.get(text.charAt(j)) > 0) {
					wordMap.put(word.charAt(j), wordMap.get(word.charAt(j)) - 1);
				}
				j++;

			} else if (j - i + 1 == wordLength) {
				if (wordMap.containsKey(text.charAt(j)) && wordMap.get(text.charAt(j)) > 0) {
					wordMap.put(text.charAt(j), wordMap.get(text.charAt(j)) - 1);
				}

				if (wordMap.values().stream().mapToInt(e -> Integer.valueOf(e)).allMatch(e -> e == 0)) {
					occurences++;
				}

				j++;

				if (wordMap.containsKey(text.charAt(i))) {
					wordMap.put(text.charAt(i), wordMap.get(text.charAt(i)) + 1);
				}
				i++;
			}
		}
		return occurences;

	}

	public static void main(String[] args) {
		String text = "forxxorfxdofr";
		String word = "for";
		System.out.println(occurenceOfAnagram(text, word));

	}

}
