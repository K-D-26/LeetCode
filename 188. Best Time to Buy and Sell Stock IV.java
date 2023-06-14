// Method 1:


class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[k+1][n];
        
        for(int t=1; t<=k; t++) {                           // t --> no. of transaction
            for(int d=1; d<n; d++) {                        // d --> no. of days
                int max = dp[t][d-1];
                
                for(int pd=0; pd<d; pd++) {
                    int ptilltm1 = dp[t-1][pd];             // profit till (t-1) transaction for all previous days
                    int ptth = prices[d] - prices[pd];      // profit made if t-th transaction is done on that day
                    
                    if(ptilltm1 + ptth > max) {
                        max = ptilltm1 + ptth;
                    }
                }
                
                dp[t][d] = max;
            }
        }
        
        return dp[k][n-1];
    }
}




// Method 2 (Optimised):

class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[k+1][n];
        
        for(int t=1; t<=k; t++) {               // t --> no. of transactions
            int max = Integer.MIN_VALUE;
            for(int d=1; d<n; d++) {            // d --> no. of days
                if(dp[t - 1][d - 1] - prices[d - 1] > max) {
                    max = dp[t - 1][d - 1] - prices[d - 1];
                }
                
                if(max + prices[d] > dp[t][d - 1]) {
                    dp[t][d] = max + prices[d];
                }
                else {
                    dp[t][d] = dp[t][d - 1];
                }
            }
        }
        
        return dp[k][n - 1];
    }
}
