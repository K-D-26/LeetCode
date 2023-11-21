class Tuple implements Comparable<Tuple> {
    int row;
    int col;
    int msf;            // maximum so far
    
    Tuple(int a, int b, int c) {
        this.row = a;
        this.col = b;
        this.msf = c;
    }
    
    @Override
    public int compareTo(Tuple o) {
        return this.msf - o.msf;
    }
}

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        boolean[][] vis = new boolean[n][n];
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        pq.add(new Tuple(0, 0, grid[0][0]));
        
        while (!pq.isEmpty()) {
            Tuple t = pq.remove();
            if (t.row == n-1 && t.col == n-1) {
                return t.msf;
            }
            
            if (vis[t.row][t.col] == true) continue;
            
            vis[t.row][t.col] = true;
            for (int i = 0; i < 4; i++) {
                int nrow = t.row + dir[i][0];
                int ncol = t.col + dir[i][1];
                if (isValid(nrow, ncol, n, n, vis)) {
                    pq.offer(new Tuple(nrow, ncol, Math.max(t.msf, grid[nrow][ncol])));
                }
            }
        }
        
        return 0;
    }
    
    private boolean isValid(int r, int c, int m, int n, boolean[][] vis) {
        return (r >= 0 && r < m && c >= 0 && c < n && vis[r][c] == false);
    }
}