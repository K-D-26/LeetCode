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
