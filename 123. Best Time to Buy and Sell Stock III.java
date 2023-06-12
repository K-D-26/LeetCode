class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int mpist = 0;                  // maximum profit if sold today
        int lsf = prices[0];            // least so far (on the left)
        int[] dpl = new int[n];         // store the maximum of (the profit we can gain if we sell stock today, (or) the maximum profit we have gained till today)
        
        for(int i=1; i<n; i++) {
            if(prices[i] < lsf) {
                lsf = prices[i];
            }
            
            mpist = prices[i] - lsf;
            if(mpist > dpl[i - 1]) {
                dpl[i] = mpist;
            }
            else {
                dpl[i] = dpl[i - 1];
            }
        }
        
        int mpibt = 0;                  // maximum profit if bought today
        int maxat = prices[n-1];        // maximum at today (on the right)
        int[] dpr = new int[n];         // store the maximum of (the profit we can gain if we bought stock today, (or) the maximum profit that we have gained by buying in the future)
        
        for(int i=n-2; i>=0; i--) {
            if(prices[i] > maxat) {
                maxat = prices[i];
            }
            
            mpibt = maxat - prices[i];
            if(mpibt > dpr[i + 1]) {
                dpr[i] = mpibt;
            }
            else {
                dpr[i] = dpr[i + 1];
            }
        }
        
        int op = 0;                     // overall profit
        for(int i=0; i<n; i++) {
            if(dpl[i] + dpr[i] > op) {
                op = dpl[i] + dpr[i];
            }
        }
        
        return op;
    }
}
