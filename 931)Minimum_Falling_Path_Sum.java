// Method 1 (Tabulation DP):

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        
        for(int i=n-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                if(i == n-1)
                    dp[i][j] = matrix[i][j];
                else if(j == 0)
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], dp[i+1][j+1]);
                else if(j == n-1)
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j], dp[i+1][j-1]);
                else
                    dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j-1], Math.min(dp[i+1][j], dp[i+1][j+1]));
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int j=0; j<n; j++)
            ans = Math.min(ans, dp[0][j]);
        
        return ans;
    }
}



// Method 2:

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for(int i=1; i<n; ++i)
            for(int j=0; j<n; ++j)
                matrix[i][j] += Math.min(matrix[i-1][j], Math.min(matrix[i-1][Math.max(0, j-1)], matrix[i-1][Math.min(n-1, j+1)]));
        return Arrays.stream(matrix[n-1]).min().getAsInt();
    }
}
