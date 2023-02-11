class Solution {
    public int uniquePaths(int m, int n) {        
        if(m == 1 || n == 1)
            return 1;
        
        m--;
        n--;
        if(m < n) {
            m = m + n;
            n = m - n;
            m = m - n;
        }
        
        long ans = 1;
        int j = 1;
        for(int i = m+1; i <= m+n; i++, j++) {
            ans *= i;
            ans /= j;
        }
            
        return (int)ans;     
    }
}
