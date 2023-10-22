// This is also an divide and sort approach.
// Select any index as pivot-index. Now, for this pivot element, store all the smaller elements than the pivot, 
// on the left of the pivot-index and all the larger elements on the right of the pivot. 
// This way pivot will be at it's correct positon. Now do the same for the remaining elements using recursion.

// Time complexity: O(n*log(n))
// Space complexity: O(1)  -->  (ignoring recursion stack)
// for recursion stack, we can say it to be O(log(n))

public class quickSort {
	public static void quickSort(int[] arr, int low, int high) {
		qs(arr, low, high);
	}

	private static void qs(int[] arr, int low, int high) {
		if(low < high) {
			int pivotIdx = partition(arr, low, high);
			qs(arr, low, pivotIdx - 1);
			qs(arr, pivotIdx + 1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[low];
		int i = low, j = high;

		while(i < j) {
			while(arr[i] <= pivot && i <= high - 1) {
				i++;
			}

			while(arr[j] > pivot && j >= low + 1) {
				j--;
			}

			if(i < j) {
				swap(arr, i, j);
			}
		}

		swap(arr, low, j);
		return j;
	}

	private static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

    public static void main(String[] args) {
        int[] arr = { 7, 4, 9, 1, 3, 5, 2, 8, 6 };

        System.out.println("\nQuick sort");
        System.out.println("\nBefore sorting:");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        quickSort(arr, 0, 8);
        System.out.println("\n\nAfter sorting:");

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }
}