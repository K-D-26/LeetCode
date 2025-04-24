/* 
    LeetCode Problem 338: Counting Bits
    https://leetcode.com/problems/counting-bits/description/
    https://youtu.be/uwOz378g3ew?feature=shared
*/

// method 1

class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        
        for (int i = 0; i < n + 1; i++) {
            int temp = i;
            int oneBitCount = 0;

            while (temp > 0) {
                if ((temp & 1) == 1) {
                    oneBitCount++;
                }
                temp >>= 1;
            }

            ans[i] = oneBitCount;
        }

        return ans;
    }
}


// method 2

class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        ans[0] = 0;

        if (n == 0) {
            return ans;
        }
        
        ans[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            if (i % 2 ==1) {
                ans[i] = ans[i/2] + 1;
            } else {
                ans[i] = ans[i/2];
            }
        }

        return ans;
    }
}