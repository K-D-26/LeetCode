class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length, n = image[0].length;
        
        int[][] copy = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = image[i][j];
            }
        }
        
        int original = image[sr][sc];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int r = q.peek()[0];
                int c = q.peek()[1];
                q.poll();
                copy[r][c] = color;
                
                for (int j = 0; j < 4; j++) {
                    int nr = r + dr[j];
                    int nc = c + dc[j];
                    if (isValid(nr, nc, m, n) && image[nr][nc] == original && copy[nr][nc] != color) {
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }
        
        return copy;
    }
    
    private boolean isValid(int nr, int nc, int m, int n) {
        return (nr >= 0 && nr < m && nc >= 0 && nc < n);
    }
}