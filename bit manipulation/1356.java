/* 
    LeetCode Problem 1356: Sort Integers by The Number of 1 Bits
    https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/description/
    https://youtu.be/2owpaafBIgw?feature=shared
*/

// method 1:

class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] boxedArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            boxedArr[i] = arr[i];
        }

        Arrays.sort(boxedArr, (a, b) -> {
            int countA = countOneBits(a);
            int countB = countOneBits(b);

            if (countA == countB) {
                return a.compareTo(b);
            }
            return Integer.compare(countA, countB);
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = boxedArr[i];
        }
        return arr;
    }

    public int countOneBits(int n) {
        int cnt = 0;
        int temp = n;
        while (temp > 0) {
            if ((temp & 1) == 1) {
                cnt++;
            }
            temp >>= 1;
        }
        return cnt;
    }
}


// method 2:

class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] boxedArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            boxedArr[i] = arr[i];
        }

        Arrays.sort(boxedArr, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);

            if (countA == countB) {
                return a.compareTo(b);
            }
            return Integer.compare(countA, countB);
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = boxedArr[i];
        }
        return arr;
    }
}