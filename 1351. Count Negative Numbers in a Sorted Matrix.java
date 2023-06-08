class Solution {
    public int countNegatives(int[][] grid) {
        int ans = 0;
        int m = grid.length, n = grid[0].length;
        
        if(grid[m-1][n-1] >= 0)
            return 0;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] < 0) {
                    ans += (m - i) * (n - j);
                    n = j;
                }
            }
        }
        
        return ans;
    }
}
