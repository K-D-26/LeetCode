// Select the smallest element from all and store it at the first index or 
// select the largest element from all and store it at the last index.
// Now, narrow your array by one size and do the same for the remaining elements.

// Time complexity: O(n^2)
// Space complexity: O(1)

public class selectionSort {
    public static void selectionSort(int[] arr) {
        for(int i=0; i<arr.length-1; i++) {
            int minIdx = i;
            for(int j=i+1; j<arr.length; j++) {
                if(arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            if(minIdx != i) {
                swap(arr, i, minIdx);
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {7, 4, 9, 1, 3, 5, 2, 8, 6};
        
        System.out.println("\nSelection sort");
        System.out.println("\nBefore sorting:");
        for(int i : arr) {
            System.out.print(i + " ");
        }

        selectionSort(arr);
        System.out.println("\n\nAfter sorting:");

        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }
}