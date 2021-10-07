package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KSmallestElement {

	private static int kSmallestElement(int array[], int K) {

		PriorityQueue<Integer> maxh = new PriorityQueue<>(Comparator.reverseOrder());

		for (int i = 0; i < array.length; i++) {
			maxh.add(array[i]);
			if (maxh.size() > K) {
				maxh.poll();
			}
		}
		return maxh.peek();
	}

	public static void main(String[] args) {

		int a[] = { 7, 10, 4, 3, 20, 15 };
		int K = 2;
		System.out.println(kSmallestElement(a, K));

	}

}
