// Method 1:

class Solution {
    public int maxProfit(int[] prices) {
        int obsp = -prices[0];
        int ossp = 0;
        int ocsp = 0;
        
        for(int i=1; i<prices.length; i++) {
            int nbsp = 0, nssp = 0, ncsp = 0;
            
            if(ocsp - prices[i] > obsp) {
                nbsp = ocsp - prices[i];
            }
            else {
                nbsp = obsp;
            }
            
            if(obsp + prices[i] > ossp) {
                nssp = obsp + prices[i];
            }
            else {
                nssp = ossp;
            }
            
            if(ossp > ocsp) {
                ncsp = ossp;
            }
            else {
                ncsp = ocsp;
            }
            
            obsp = nbsp;
            ossp = nssp;
            ocsp = ncsp;
        }
        
        return ossp;
    }
}


// Method 2:

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2)
            return 0;        
        int b0 = -prices[0], b1 = b0;
        int s0 = 0, s1 = 0, s2 = 0;        
        for(int i=1; i<prices.length; i++) {
            b0 = Math.max(b1, s2-prices[i]);
            s0 = Math.max(s1, b1+prices[i]);
            b1 = b0;
            s2 = s1;
            s1 = s0;
        }
        return s0;
    }
}
