// Method 1 (Square and multiply):

class Solution {
    public double myPow(double x, int n) {
        // square and multiply
        long p = n;
        if(n < 0) {
            p = -1 * p;
        }
        
        double ans = 1.0;
        
        while(p > 0) {
            if((p & 1) == 1) {
                ans *= x;
            }
            x = x * x;
            p = p >> 1;
        }
        
        return (n > 0) ? ans : 1.0 / ans;
    }
}


// Method 2 (Recursion):

class Solution {
    public double myPow(double x, int n) {
        // recursion
        if(x == 0 || x == 1 || n == 1) return x;
        
        if(n == 0) return 1;
        
        if(n < 0) return (1/x * myPow(1/x, -(n+1)));
        
        return n % 2 == 0 ? myPow(x*x, n/2) : x * myPow(x*x, n/2);
    }
}
