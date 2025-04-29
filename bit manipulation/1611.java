/* 
    LeetCode Problem 1611: Minimum One Bit Operations to Make Integers Zero
    https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/description/
    https://youtu.be/yU6DZSLW4_c?feature=shared
*/

class Solution {
    public int minimumOneBitOperations(int n) {
        if (n == 0) {
            return 0;
        }

        int[] F = new int[31];
        F[0] = 1;
        for (int i = 1; i < 31; i++) {
            F[i] = (2 * F[i-1]) + 1;
        }

        int ans = 0;
        boolean sign = true;

        for (int i = 30; i >= 0; i--) {
            int ith_bit = (1 << i) & n;

            if (ith_bit == 0) {
                continue;
            } else {
                if (sign) {
                    ans += F[i];
                } else {
                    ans -= F[i];
                }
            }

            sign = !sign;
        }

        return ans;
    }
}