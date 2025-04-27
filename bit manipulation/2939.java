/* 
    LeetCode Problem 2939: Maximum XOR Product
    https://leetcode.com/problems/maximum-xor-product/description/
    https://youtu.be/rCnELsv6L2I?feature=shared
*/

class Solution {
    public int maximumXorProduct(long a, long b, int n) {
        int mod = 1000000007;

        long xXorA = 0;
        long xXorB = 0;

        // from 49th bit to nth bit
        for (long i = 49; i >= n; i--) {
            boolean a_ith_bit_set = ((a >> i) & 1) > 0;     // finding ith bit of a
            boolean b_ith_bit_set = ((b >> i) & 1) > 0;     // finding ith bit of b

            if (a_ith_bit_set) {
                xXorA = (xXorA ^ (1L << i));
            }
            if (b_ith_bit_set) {
                xXorB = (xXorB ^ (1L << i));
            }
        }

        // from (n-1)th bit to 0th bit
        for (long i = n - 1; i >= 0; i--) {
            boolean a_ith_bit_set = (a & (1L << i)) > 0;     // finding ith bit of a
            boolean b_ith_bit_set = (b & (1L << i)) > 0;     // finding ith bit of b

            if (a_ith_bit_set == b_ith_bit_set) {
                xXorA = (xXorA ^ (1L << i));
                xXorB = (xXorB ^ (1L << i));
                continue;
            } else {
                if (xXorA > xXorB) {
                    xXorB = (xXorB ^ (1L << i));
                } else {
                    xXorA = (xXorA ^ (1L << i));
                }
            }
        }

        xXorA %= mod;
        xXorB %= mod;

        return (int)((xXorA * xXorB) % mod);
    }
}