package slidingWindow;

public class MaxSubArrayWithWindow {
	
	public static int maxSubArrayWithWidow(int array[], int window) {
		
		int sum = 0, currentSum = 0;
		int i=0, j=0;
		
		while (j < array.length) {
			
			if (j-i+1 < window) {
				currentSum = currentSum + array[j];
				j++;
			}
			else if (j-i+1 == window) {
				currentSum = currentSum + array[j];
				if (currentSum > sum)
					sum = currentSum;
				currentSum = currentSum - array[i];
				j++; i++;				
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		int array[] = {2,4,8,7,4,0,6,1,2,7,5,5,3,1,1,0};
		int window = 3;
		System.out.println(maxSubArrayWithWidow(array,window));

	}

}
