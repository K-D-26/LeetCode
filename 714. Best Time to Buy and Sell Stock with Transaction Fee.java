class Solution {
    public int maxProfit(int[] prices, int fee) {
        int obsp = -prices[0];                      // old buy state profit
        int ossp = 0;                               // old sell state profit
        
        for(int i=1; i<prices.length; i++) {
            int nbsp = 0;                           // new buy state profit
            int nssp = 0;                           // new sell state profit
            
            if(ossp - prices[i] > obsp) {           // if we can reduce our loan
                nbsp = ossp - prices[i];
            }
            else {
                nbsp = obsp;
            }
            
            if(obsp + prices[i] - fee > ossp) {     // if we can get more prodit
                nssp = obsp + prices[i] - fee;
            }
            else {
                nssp = ossp;
            }
            
            obsp = nbsp;
            ossp = nssp;
        }
        
        return ossp;
    }
}
