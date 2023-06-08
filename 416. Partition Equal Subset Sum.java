class Solution {
    public boolean canPartition(int[] arr) {
        int sum = 0;
        for(int i : arr)
            sum += i;
        
        if(sum % 2 == 1)
            return false;
        
        sum /= 2;
        int n = arr.length;
        int[][] dp = new int[n+1][sum+1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=sum; j++) {
                if(i == 0 && j == 0)
                    dp[i][j] = 1;
                else if(i == 0)
                    dp[i][j] = 0;
                else if(j == 0)
                    dp[i][j] = 1;
                else {
                    if(dp[i-1][j] == 1) {
                        dp[i][j] = 1;
                    }
                    else {
                        if(j >= arr[i-1] && dp[i-1][j-arr[i-1]] == 1)
                            dp[i][j] = 1;
                    }
                }
            }
        }
        
        return dp[n][sum] == 1;
    }
}
