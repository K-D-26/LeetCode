class Solution {
    public int numTilings(int n) {
        if(n < 3)
            return n;
        
        double mod = Math.pow(10, 9);
        mod += 7;
        double[] arr = new double[n+1];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 5;
        
        for(int i=4; i<=n; i++)
            arr[i] = (2*arr[i-1] + arr[i-3]) % mod;
        
        return (int)arr[n];
    }
}
