// Method 1 (Memoization):

class Solution {
    int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length+1];
        Arrays.fill(memo, -1);
        return rob(nums, nums.length-1);
    }
    
    private int rob(int[] nums, int n) {
        if(n < 0)
            return 0;
        if(memo[n] >= 0)
            return memo[n];
        memo[n] = Math.max(rob(nums, n-2) + nums[n], rob(nums, n-1));
        return memo[n];
    }
}



// Method 2 (Tabulation + space optimized):

class Solution {
    public int rob(int[] nums) {
        // Tabulation (space optimized)
        
        int n = nums.length;
        int prev2 = 0, prev = nums[0];
        
        for(int i=1; i<n; i++) {
            int rob = nums[i];
            if(i > 1)
                rob += prev2;
            int notRob = prev;
            int curr = Math.max(rob, notRob);            
            prev2 = prev;
            prev = curr;
        }
        
        return prev;
    }
}
