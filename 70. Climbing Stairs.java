class Solution {
    public int climbStairs(int n) {
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            if(i < 2)
                arr[i] = i+1;
            else
                arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n-1];
    }
}


// Question is indirectly about Fibonacci Series.
