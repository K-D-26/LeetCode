class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            // first col
            if (grid[i][0] == 1 && vis[i][0] == false) {
                dfs(i, 0, vis, grid);
            }
            // last col
            if (grid[i][n-1] == 1 && vis[i][n-1] == false) {
                dfs(i, n-1, vis, grid);
            }
        }
        
        for (int i = 0; i < n; i++) {
            // first row
            if (grid[0][i] == 1 && vis[0][i] == false) {
                dfs(0, i, vis, grid);
            }
            // last row
            if (grid[m-1][i] == 1 && vis[m-1][i] == false) {
                dfs(m-1, i, vis, grid);
            }
        }
        
        int ans = 0;
        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if (grid[i][j] == 1 && vis[i][j] == false) {
                    ans++;
                }
            }
        }
        
        return ans;
    }
    
    private void dfs(int i, int j, boolean[][] vis, int[][] grid) {
        vis[i][j] = true;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int m = grid.length, n = grid[0].length;

        for (int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1 && vis[nr][nc] == false) {
                dfs(nr, nc, vis, grid);
            }
        }
    }
}