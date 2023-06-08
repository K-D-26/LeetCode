class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        Arrays.sort(coins);
        
        for(int amt=1; amt<=amount; amt++) {
            dp[amt] = Integer.MAX_VALUE;
            for(int coin : coins) {
                if(amt - coin < 0)
                    break;
                if(dp[amt - coin] != Integer.MAX_VALUE)
                    dp[amt] = Math.min(dp[amt], 1 + dp[amt - coin]);
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
