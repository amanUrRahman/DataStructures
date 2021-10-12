package slidingWindow;

import java.util.ArrayList;
import java.util.List;

public class FirstNegativeNumber {

	public static void firstNegativeNumberWithWindow(int array[], int window) {

		int i = 0, j = 0;
		List<Integer> list = new ArrayList<>();

		while (j < array.length) {
			if (j - i + 1 < window) {
				if (array[j] < 0) {
					list.add(array[j]);
				}
				j++;
			} else if (j - i + 1 == window) {
				if (array[j] < 0)
					list.add(array[j]);
				if (list.isEmpty())
					System.out.print(0 + " ");
				else
					System.out.print(list.get(0) + " ");
				j++;
				if (!list.isEmpty() && array[i] == list.get(0))
					list.remove(0);
				i++;
			}
		}
	}

	public static void main(String[] args) {
		int array[] = { 2, -2, -4, 7, -6, 0, 6, 1, -6, -9, -1, 5, 3, 1, 1, 0, -4 };
		// o/p 3 ---> -2, -2, -4, -6, -6, 0, -6, -6, -6, -9, -1, 0, 0, 0, -4
		// o/p 4 ---> -2,-2,-4,-6,-6,-6,-6,-6,-6,-9,-1,0,0,-4
		int window = 3;
		firstNegativeNumberWithWindow(array, window);

	}

}
