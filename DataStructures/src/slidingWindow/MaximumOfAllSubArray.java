package slidingWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaximumOfAllSubArray {

	public static List<Integer> maximumOfAllSubArray(int array[], int window) {

		int i = 0, j = 0;
		Stack<Integer> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();

		while (j < array.length) {
			if (j - i + 1 < window) {
				if (stack.isEmpty() || stack.peek() <= array[j]) {
					stack.push(array[j]);
				}
				j++;
			} else if (j - i + 1 == window) {
				if (stack.peek() <= array[j]) {
					stack.push(array[j]);
				}
				list.add(stack.peek());

				j++;

				if (stack.peek() == array[i])
					stack.pop();
				i++;
			}
		}
		return list;
	}

	public static void main(String[] args) {
		int array[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int window = 3;
		
		// op = 3,3,5,5,6,7
		
		System.out.println(maximumOfAllSubArray(array, window));

	}

}
