class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        int m = 0;
        for(int i=0; i<n; i++) {
            ans[m] = nums[i];
            ans[m+1] = nums[i+n];
            m += 2;
        }
        return ans;
    }
}
