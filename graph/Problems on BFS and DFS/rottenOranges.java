class Pair {
    int i;
    int j;
    
    public Pair(int a, int b) {
        this.i = a;
        this.j = b;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int cntFresh = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j));
                }
                else if (grid[i][j] == 1) {
                    cntFresh++;
                }
            }
        }
        
        if (cntFresh == 0) return 0;
        
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        int convert = 0;
        int time = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int row = q.peek().i;
                int col = q.peek().j;
                q.poll();
                
                for (int j = 0; j < 4; j++) {
                    int nrow = row + drow[j];
                    int ncol = col + dcol[j];
                    
                    if (isValid(nrow, ncol, m, n) && grid[nrow][ncol] == 1) {
                        grid[nrow][ncol] = 2;
                        q.offer(new Pair(nrow, ncol));
                        convert++;
                    }
                }
            }
            
            if (!q.isEmpty()) {
                time++;
            }
        }
        
        return (cntFresh == convert) ? time : -1;
    }
    
    private static boolean isValid(int i, int j, int m, int n) {
        return (i >= 0 && i < m && j >= 0 && j < n);
    }
}