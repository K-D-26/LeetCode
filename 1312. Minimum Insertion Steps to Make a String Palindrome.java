// Method 1: Using StringBuilder

class Solution {
    public int minInsertions(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        String t = sb.toString();
        
        int a = s.length();
        int b = a;
        int ans = 0;
        
        // LCS (Tabulation)
        int[][] dp = new int[a+1][b+1];
        for(int i=0; i<=a; i++) {
            dp[i][0] = 0;
            dp[0][i] = 0;
        }
        for(int i=1; i<=a; i++) {
            for(int j=1; j<=b; j++) {
                if(s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                ans = Math.max(ans, dp[i][j]);
            }
        }
        
        return a - ans;
    }
}


// Method 2: Without using StringBuilder (optimised)

class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        
        for (int i=0; i<n; ++i)
            for (int j=0; j<n; ++j)
                dp[i+1][j+1] = s.charAt(i) == s.charAt(n-1-j) ? dp[i][j] + 1 : Math.max(dp[i][j+1], dp[i+1][j]);
        
        return n - dp[n][n];
    }
}
