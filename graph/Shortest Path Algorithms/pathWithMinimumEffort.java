class tuple {
    int distance;
    int row;
    int col;
    public tuple(int a, int b, int c) {
        this.distance = a;
        this.row = b;
        this.col = c;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<tuple> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int m = heights.length;
        int n = heights[0].length;
        int[][] dist = new int[m][n];

        for (int[] a : dist) {
            Arrays.fill(a, (int)(1e9));
        }
        dist[0][0] = 0;
        
        pq.offer(new tuple(0, 0, 0));
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        while (!pq.isEmpty()) {
            tuple t = pq.peek();
            pq.poll();
            int diff = t.distance;
            int r = t.row;
            int c = t.col;
            
            if (r == m-1 && c == n-1) {
                return diff;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (isValid(nr, nc, m, n)) {
                    int newEffort = Math.max(Math.abs(heights[r][c] - heights[nr][nc]), diff);
                    if (newEffort < dist[nr][nc]) {
                        dist[nr][nc] = newEffort;
                        pq.offer(new tuple(newEffort, nr, nc));
                    }
                }
            }
        }
        
        return 0;
    }
    
    private boolean isValid(int r, int c, int m, int n) {
        return (r >= 0 && r < m && c >= 0 && c < n);
    }
}