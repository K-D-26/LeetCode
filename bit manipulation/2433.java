/* 
    LeetCode Problem 2433: Find The Original Array of Prefix XOR
    https://leetcode.com/problems/find-the-original-array-of-prefix-xor/description/
    https://youtu.be/TDjmp768H3Q?feature=shared
*/

// method 1:

class Solution {
    public int[] findArray(int[] pref) {
        int[] ans = new int[pref.length];
        ans[0] = pref[0];

        for (int i = 1; i < pref.length; i++) {
            ans[i] = pref[i] ^ pref[i - 1];
        }

        return ans;
    }
}


// method 2 (using the same input array & not consuming extra space by starting from the end of array):

class Solution {
    public int[] findArray(int[] pref) {
        for (int i = pref.length - 1; i > 0; i--) {
            pref[i] = pref[i] ^ pref[i - 1];
        }

        return pref;
    }
}