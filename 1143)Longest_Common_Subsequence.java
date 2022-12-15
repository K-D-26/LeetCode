// Memoization:

class Solution {
    private Integer[][] dp;
    public int longestCommonSubsequence(String text1, String text2) { 
        dp = new Integer[text1.length()][text2.length()];
        return LCS(text1, text2, 0, 0);
    }
    
    private int LCS(String text1, String text2, int m, int n) {
        if(m == text1.length() || n == text2.length())
            return 0;
        if(dp[m][n] != null)
            return dp[m][n];        
        if(text1.charAt(m) == text2.charAt(n))
            return dp[m][n] = 1 + LCS(text1, text2, m+1, n+1);
        else
            return dp[m][n] = Math.max(LCS(text1, text2, m+1, n), LCS(text1, text2, m, n+1));
    }
}



// Recursion (TLE will occur):

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        return LCS(text1, text2, n, m);
    }
    
    private int LCS(String text1, String text2, int n, int m) {        
        if(n == 0 || m == 0)
            return 0;
        if(text1.charAt(n-1) == text2.charAt(m-1))
            return 1 + LCS(text1, text2, n-1, m-1);
        return Math.max(LCS(text1, text2, n-1, m), LCS(text1, text2, n, m-1));        
    }
}
