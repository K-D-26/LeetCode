/* 
    LeetCode Problem 1318: Minimum Flips to make a OR b Equals c
    https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/
    https://youtu.be/Gx4-uOkopMA?feature=shared
*/

// method 1

class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;

        while (a != 0 || b != 0 || c != 0) {
            if ((c & 1) == 1) {
                if ((a & 1) == 0 && (b & 1) == 0) {
                    flips++;
                }
            } else {
                if ((a & 1) == 1) {
                    flips++;
                }
                if ((b & 1) == 1) {
                    flips++;
                }
            }

            a >>= 1;
            b >>= 1;
            c >>= 1;
        }

        return flips;
    }
}


// method 2

class Solution {
    public int minFlips(int a, int b, int c) {
        int temp1 = ((a | b) ^ c);

        int temp2 = (a & b);

        return countSetBits(temp1) + countSetBits((temp2 & temp1));
    }

    private int countSetBits(int n) {
        int ans = 0;

        while (n != 0) {
            if ((n & 1) == 1) {
                ans++;
            }
            n >>= 1;
        }

        return ans;
    }
}