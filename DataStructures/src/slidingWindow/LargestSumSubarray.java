package slidingWindow;

public class LargestSumSubarray {

	public static int largestSumSubArray(int A[]) {

		int i = 0, j = 0;
		int largestSum = Integer.MIN_VALUE;
		int currentSum = 0;
		

		while (j < A.length) {

			currentSum = currentSum + A[j];

			if (currentSum > largestSum) {
				largestSum = currentSum;
				
			}
			
			if (currentSum < 0) {
				currentSum = 0;
			}
			j++;
			

		}

		return largestSum;
	}

	public static void main(String[] args) {
		int A[] = { 4, 2, -5, 1, 2, 3, 6, -5, 1 };
		int B[] = { -1, -2, -3, 3, -5, -6, -7 };
		System.out.println(largestSumSubArray(B));

	}

}
