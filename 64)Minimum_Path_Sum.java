// Method 1 (Tabulation):

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        
        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                if(i == m-1 && j == n-1)
                    dp[i][j] = grid[i][j];
                else if(i == m-1)
                    dp[i][j] = grid[i][j] + dp[i][j+1];
                else if(j == n-1)
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                else
                    dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
            }
        }
        
        return dp[0][0];
    }
}


        
// Method 2 (Tabulation & space optimised):

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] prev = new int[n];
        
        for(int i=0; i<m; i++) {
            int[] curr = new int[n];
            for(int j=0; j<n; j++) {
                if(i == 0 && j == 0)
                    curr[j] = grid[i][j];
                
                else {
                    int up = grid[i][j];
                    if(i > 0)
                        up += prev[j];
                    else
                        up += (int)Math.pow(10, 9);
                    
                    int left = grid[i][j];
                    if(j > 0)
                        left += curr[j-1];
                    else
                        left += (int)Math.pow(10, 9);
                    
                    curr[j] = Math.min(up, left);
                }
            }
            prev = curr;
        }
        
        return prev[n-1];
    }
}
