// For each pair of elements, check which element is larger, and move it to the right.
// By one complete iteration, the largest element will be present at the last index of the array.
// Similarly go on swapping the elements and eventually we will get the sorted array.

// Time complexity: O(n^2)
// Space complexity: O(1)

public class bubbleSort {
    public static void bubbleSort(int[] arr, int n) {
        for(int i=0; i<n; i++) {
            for(int j=n-1; j>=i; j--) {
                if(arr[j] < arr[i]) {
                    swap(arr, i, j);
                }
            }
        }
        
        // for(int i=n-1; i>=0; i--) {
        //     for(int j=0; j<=i; j++) {
        //         if(arr[j] > arr[i]) {
        //             swap(arr, i, j);
        //         }
        //     }
        // }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = { 7, 4, 9, 1, 3, 5, 2, 8, 6 };

        System.out.println("\nBubble sort");
        System.out.println("\nBefore sorting:");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        bubbleSort(arr, 9);
        System.out.println("\n\nAfter sorting:");

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }
}