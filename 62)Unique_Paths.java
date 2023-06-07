// Method 1: Using DP (0ms solution)

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                if(i == m-1 || j == n-1)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        
        return dp[0][0];
    }
}


// Method 2:

class Solution {
    public int uniquePaths(int m, int n) {        
        if(m == 1 || n == 1)
            return 1;
        
        m--;
        n--;
        if(m < n) {
            m = m + n;
            n = m - n;
            m = m - n;
        }
        
        long ans = 1;
        int j = 1;
        for(int i = m+1; i <= m+n; i++, j++) {
            ans *= i;
            ans /= j;
        }
            
        return (int)ans;     
    }
}
