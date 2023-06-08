class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        
        // Combination of coins
        for(int i=0; i<coins.length; i++) {
            for(int j=coins[i]; j<dp.length; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        
        /*
        // Use the below code for getting the number of possible,
        // Permutation of coins
        for(int amt=1; amt<=amount; amt++) {
            for(int coin : coins) {
                if(coin <= amt) {
                    int ramt = amt - coin;
                    dp[amt] += dp[ramt];
                }
            }
        }
        */
        
        return dp[amount];
    }
}
