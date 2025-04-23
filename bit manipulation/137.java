/* 
    LeetCode Problem 137: Single Number 2
    https://leetcode.com/problems/single-number-ii/description/
    https://youtu.be/LK0c7tCzKmM?feature=shared
*/

// method 1 (using hash map):

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            if (i.getValue() == 1) {
                return i.getKey();
            }
        }

        return -1;
    }
}


// method 2 (using bit manipulation):

class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;

        for (int k = 0; k < 32; k++) {
            int temp = (1 << k);
            int onesCount = 0;

            for (int n : nums) {
                if ((n & temp) != 0) {
                    onesCount++;
                }
            }

            if ((onesCount % 3) == 1) {
                ans = (ans | temp);
            }
        }

        return ans;
    }
}