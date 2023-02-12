class Solution {
    public int uniquePathsWithObstacles(int[][] mat) {
        // Tabulation (space optimised)
        int mod = (int)Math.pow(10, 9) * 2;
        int n = mat.length, m = mat[0].length;
        int[] prev = new int[m];
        
        for(int i=0; i<n; i++) {
            int[] curr = new int[m];
            for(int j=0; j<m; j++) {
                if(mat[i][j] == 1)
                    curr[j] = 0;
                else if(i == 0 && j == 0)
                    curr[j] = 1;
                else {
                    int up = 0, left = 0;
                    if(i > 0)
                        up = prev[j];
                    if(j > 0)
                        left = curr[j-1];
                    curr[j] = (up + left) % mod;
                }
            }
            prev = curr;
        }
        
        return prev[m-1];
    }
}
