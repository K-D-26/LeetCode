class Solution {
    int[] dp;
    
    public int numberOfArrays(String s, int k) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        
        return helper(s, k, 0);
    }
    
    private int helper(String s, int k, int i) {
        if(i == s.length())
            return 1;
        
        if(s.charAt(i) == '0')
            return 0;
        
        if(dp[i] != -1)
            return dp[i];
        
        long num = 0;
        int ans = 0;
        for(int j=i; j<s.length(); j++) {
            num = num*10 + (s.charAt(j) - '0');
            if(num > k)
                break;
            ans += helper(s, k, j+1);
            ans %= 1000000007;
        }
        
        return dp[i] = ans;
    }
}
