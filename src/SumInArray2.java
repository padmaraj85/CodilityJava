
import java.util.Arrays;
import java.util.HashSet;

/**
 * * Java Program to find pairs on integer array whose sum is equal to k *
 * * @author WINDOWS 8
 */
public class SumInArray2 {
	public static void main(String args[]) {
		int[] numbers = { 2, 4, 3, 5, 7, 8, 9 };
		int[] numbersWithDuplicates = { 2, 4, 3, 5, 6, -2, 4, 7, 8, 9 };
		prettyPrint(numbers, 7);
		prettyPrint(numbersWithDuplicates, 7);
	}

	/**
	 * * Prints all pair of integer values from given array whose sum is is equal to
	 * given number. * complexity of this solution is O(n^2)
	 */
	public static void printPairs(int[] array, int sum) {
		for (int i = 0; i < array.length; i++) {
			int first = array[i];
			for (int j = i + 1; j < array.length; j++) {
				int second = array[j];
				if ((first + second) == sum) {
					System.out.printf("(%d, %d) %n", first, second);
				}
			}
		}
	}

	/** * Utility method to print input and output for better explanation. */
	public static void prettyPrint(int[] givenArray, int givenSum) {
		System.out.println("Given array : " + Arrays.toString(givenArray));
		System.out.println("Given sum : " + givenSum);
		System.out.println("Integer numbers, whose sum is equal to value : " + givenSum);
		printPairs(givenArray, givenSum);
	}
}

class PrintArrayPairs {
	public static void main(String args[]) {
		prettyPrint(new int[] { 12, 14, 17, 15, 19, 20, -11 }, 9);
		prettyPrint(new int[] { 2, 4, 7, 5, 9, 10, -1 }, 9);
	}

	/**
	 * * Given a number finds two numbers from an array so that the sum is equal to
	 * that number k. * @param numbers * @param k
	 */
	public static void printPairsUsingTwoPointers(int[] numbers, int k) {
		if (numbers.length < 2) {
			return;
		}
		Arrays.sort(numbers);
		int left = 0;
		int right = numbers.length - 1;
		while (left < right) {
			int sum = numbers[left] + numbers[right];
			if (sum == k) {
				System.out.printf("(%d, %d) %n", numbers[left], numbers[right]);
				left = left + 1;
				right = right - 1;
			} else if (sum < k) {
				left = left + 1;
			} else if (sum > k) {
				right = right - 1;
			}
		}
	}

	/* * Utility method to print two elements in an array that sum to k. */ public static void prettyPrint(int[] random,
			int k) {
		System.out.println("input int array : " + Arrays.toString(random));
		System.out.println("All pairs in an array of integers whose sum is equal to a given value " + k);
		printPairsUsingTwoPointers(random, k);
	}
}

class PairSum {
	static void printpairs(int arr[], int sum) {
		HashSet<Integer> s = new HashSet<Integer>();
		for (int i = 0; i < arr.length; ++i) {
			int temp = sum - arr[i];

			// checking for condition
			if (s.contains(temp)) {
				System.out.println("Pair with given sum " + sum + " is (" + arr[i] + ", " + temp + ")");
			}
			s.add(arr[i]);
		}
	}

	// Main to test the above function
	public static void main(String[] args) {
		int A[] = { 1, 4, 8, 45, 6, 8, 10, 8 };
		int n = 16;
		printpairs(A, n);
	}
}

class CloseSum {

	// Prints the pair with sum cloest to x
	static void printClosest(int arr[], int n, int x) {
		int res_l = 0, res_r = 0; // To store indexes of result pair

		// Initialize left and right indexes and difference between
		// pair sum and x
		int l = 0, r = n - 1, diff = Integer.MAX_VALUE;

		// While there are elements between l and r
		while (r > l) {
			// Check if this pair is closer than the closest pair so far
			if (Math.abs(arr[l] + arr[r] - x) < diff) {
				res_l = l;
				res_r = r;
				diff = Math.abs(arr[l] + arr[r] - x);
			}

			// If this pair has more sum, move to smaller values.
			if (arr[l] + arr[r] > x)
				r--;
			else // Move to larger values
				l++;
		}

		System.out.println(" The closest pair is " + arr[res_l] + " and " + arr[res_r]);
	}

	// Driver program to test above function
	public static void main(String[] args) {
		int arr[] = { 10, 22, 28, 29, 30, 40 }, x = 54;
		int n = arr.length;
		printClosest(arr, n, x);
	}
}
