class Solution {
    public int rob(int[] arr) {
        int n = arr.length;
        if(n == 1)
            return arr[0];
        
        int[] dp = new int[n];
        
        // take last
        for(int i=n-1; i>=1; i--) {
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
        
        int ans = dp[1];
        
        // take first
        for(int i=n-2; i>=0; i--) {
            if(i == n-2) {
                dp[i] = arr[i];
            }
            else if(i == n-3) {
                dp[i] = Math.max(arr[i], arr[i+1]);
            }
            else {
                dp[i] = Math.max(arr[i] + dp[i+2], dp[i+1]);
            }
        }
        
        return Math.max(ans, dp[0]);
    }
}
