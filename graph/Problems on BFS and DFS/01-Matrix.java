class Tuple {
    int row;
    int col;
    int steps;
    public Tuple(int r, int c, int s) {
        this.row = r;
        this.col = c;
        this.steps = s;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        Queue<Tuple> q = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    vis[i][j] = true;
                    q.offer(new Tuple(i, j, 0));
                }
            }
        }
        
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        while (!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().col;
            int steps = q.peek().steps;
            q.poll();
            dist[row][col] = steps;
            
            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && vis[nr][nc] == false) {
                    q.offer(new Tuple(nr, nc, steps + 1));
                    vis[nr][nc] = true;
                }
            }
        }
        
        return dist;
    }
}