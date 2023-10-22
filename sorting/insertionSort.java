// Take an array element and insert it at it's correct position. 
// We will hypothetically divide the array into two parts. One which is sorted and one which is unsorted. 
// One by one take an element into the sorted part and store it at its correct position.
// At the end every element will end up at it's correct position in the sorted portion. 

// Time complexity: O(n^2)
// Space complexity: O(1)

public class insertionSort {
    public static void insertionSort(int[] arr, int n) {
        for(int i=0; i<n; i++) {
            int j = i;
            while(j > 0 && arr[j-1] > arr[j]) {
                int t = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = t;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 7, 4, 9, 1, 3, 5, 2, 8, 6 };

        System.out.println("\nInsertion sort");
        System.out.println("\nBefore sorting:");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        insertionSort(arr, 9);
        System.out.println("\n\nAfter sorting:");

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }
}