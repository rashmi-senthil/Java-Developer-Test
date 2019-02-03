import java.util.Arrays;
import java.util.Scanner;

public class countingPairs {
	static int search(int arr[], int low, int high, int x) {
		if (high >= low) {
			int mid = low + (high - low) / 2;
			if (x == arr[mid])
				return mid;
			if (x > arr[mid])
				return search(arr, (mid + 1), high, x);
			else
				return search(arr, low, (mid - 1), x);
		}
		return -1;
	}

	static int countingPairsImpl(int arr[], int k) {
		int end = arr.length;
		for (int i = 0; i < end; i++) {
			for (int j = i + 1; j < end; j++) {
				if (arr[i] == arr[j]) {
					arr[j] = arr[end - 1];
					end--;
					j--;
				}
			}
		}
		int[] arrWithoutDup = new int[end];
		System.arraycopy(arr, 0, arrWithoutDup, 0, end);
		int count = 0, c;
		Arrays.sort(arrWithoutDup);
		for (c = 0; c < arrWithoutDup.length - 1; c++)
			if (search(arrWithoutDup, c + 1, arrWithoutDup.length - 1, arrWithoutDup[c] + k) != -1)
				count++;

		return count;
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		int k = in.nextInt();
		System.out.println(countingPairsImpl(arr, k));
	}
}
