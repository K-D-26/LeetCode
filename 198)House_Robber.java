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



// Method 2 (Tabulation):

class Solution {
    public int rob(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        for(int i=n-1; i>=0; i--) {
            if(i == n-1) {
                dp[i] = arr[i];
            }
            else if(i == n-2) {
                dp[i] = Math.max(arr[i], arr[i+1]);
            }
            else {
                dp[i] = Math.max(arr[i] + dp[i+2], dp[i+1]);
            }
        }
        
        return dp[0];
    }
}



// Method 3 (Tabulation + space optimized):

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
