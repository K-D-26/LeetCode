class Solution {
    public int maxProfit(int[] prices) {
        int lsf = prices[0];        // least price so far
        int mp = 0;                 // maximum profit earned
        
        for(int i=1; i<prices.length; i++) {
            if(prices[i] < lsf) {
                lsf = prices[i];
            }
            
            int p = prices[i] - lsf;        // profit
            if(p > mp) {
                mp = p;
            }
        }
        
        return mp;
    }
}
