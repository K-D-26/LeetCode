class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        for (int i = 0; i < m; i++) {
            // first col
            if (board[i][0] == 'O' && vis[i][0] == false) {
                dfs(i, 0, vis, dr, dc, board);
            }
            // last col
            if (board[i][n-1] == 'O' && vis[i][n-1] == false) {
                dfs(i, n-1, vis, dr, dc, board);
            }
        }
        
        for (int i = 0; i < n; i++) {
            // first row
            if (board[0][i] == 'O' && vis[0][i] == false) {
                dfs(0, i, vis, dr, dc, board);
            }
            // last row
            if (board[m-1][i] == 'O' && vis[m-1][i] == false) {
                dfs(m-1, i, vis, dr, dc, board);
            }
        }
        
        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if (board[i][j] == 'O' && vis[i][j] == false) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void dfs(int i, int j, boolean[][] vis, int[] dr, int[] dc, char[][] board) {
        vis[i][j] = true;
        int m = board.length, n = board[0].length;
        for (int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && board[nr][nc] == 'O' && vis[nr][nc] == false) {
                dfs(nr, nc, vis, dr, dc, board);
            }
        }
    }
}