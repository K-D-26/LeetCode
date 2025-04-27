/* 
    LeetCode Problem 191: Number of 1 Bits
    https://leetcode.com/problems/number-of-1-bits/description/
    https://youtu.be/YOyajw-L0pc?feature=shared
*/

// method 1: TC = O(32) = O(1)

class Solution {
    public int hammingWeight(int n) {
        int cnt = 0;

        for (int i = 31; i >= 0; i--) {
            if (((n >> i) & 1) == 1) {
                cnt++;
            }
        }

        return cnt;
    }
}


// method 2: TC = O(k) where k = no. of 1 bits in n

class Solution {
    public int hammingWeight(int n) {
        int cnt = 0;

        while (n > 0) {
            n &= n - 1;
            cnt++;
        }

        return cnt;
    }
}


// method 3: TC = log(n)

class Solution {
    public int hammingWeight(int n) {
        int cnt = 0;

        while (n > 0) {
            cnt += (n % 2);
            n /= 2;
        }

        return cnt;
    }
}


// method 4: TC = O(1)

class Solution {
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}