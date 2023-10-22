// We use divide and sort method in this sorting algorithm.
// Using recursion, divide the array to a single element, now there will be n arrays of 1 length.
// Now, we combine these sorted arrays of unit length to form the final array. 

// Time complexity: O(n*log(n))
// Space complexity: O(n)

import java.util.*;

public class mergeSort {
    public static void mergeSort(int[] arr, int low, int high) {
        if(low == high) return;

        int mid = (high - low) / 2 + low;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int left = low, right = mid+1;
        List<Integer> temp = new ArrayList<>();

        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                temp.add(arr[left++]);
            }
            else {
                temp.add(arr[right++]);
            }
        }

        while(left <= mid) {
            temp.add(arr[left++]);
        }

        while(right <= high) {
            temp.add(arr[right++]);
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 7, 4, 9, 1, 3, 5, 2, 8, 6 };

        System.out.println("\nMerge sort");
        System.out.println("\nBefore sorting:");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        mergeSort(arr, 0, 8);
        System.out.println("\n\nAfter sorting:");

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }
}
