// problem: https://practice.geeksforgeeks.org/problems/shortest-path-in-a-binary-maze-1655453161/1

class Tuple {
    int distance;
    int x;
    int y;
    public Tuple(int a, int b, int c) {
        this.distance = a;
        this.x = b;
        this.y = c;
    }
}

class Solution {
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        if (source[0] == destination[0] && source[1] == destination[1]) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = (int)(1e9);
            }
        }
        dist[source[0]][source[1]] = 1;
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(0, source[0], source[1]));
        
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        
        while (!q.isEmpty()) {
            Tuple t = q.peek();
            q.poll();
            int d = t.distance;
            int i = t.x;
            int j = t.y;
            for (int k = 0; k < 4; k++) {
                int newi = i + dr[k];
                int newj = j + dc[k];
                if (isValid(newi, newj, m, n) && grid[newi][newj] == 1 && d + 1 < dist[newi][newj]) {
                    dist[newi][newj] = d + 1;
                    if (newi == destination[0] && newj == destination[1]) {
                        return d + 1;
                    }
                    q.offer(new Tuple(d+1, newi, newj));
                }
            }
        }
        
        return -1;
    }
    
    private boolean isValid(int r, int c, int m, int n) {
        return (r >= 0 && r < m && c >= 0 && c < n);
    }
}


// leetcode: https://leetcode.com/problems/shortest-path-in-binary-matrix/

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }

        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        int ans = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pop = queue.remove();
                if (pop[0] == n-1 && pop[1] == n-1) {
                    return ans + 1;
                }
                for (int k=0;k<8;k++) {
                    int nextX = dir[k][0]+pop[0];
                    int nextY = dir[k][1]+pop[1];

                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !visited[nextX][nextY] && grid[nextX][nextY] == 0) {
                        queue.add(new int[]{nextX,nextY});
                        visited[nextX][nextY] = true;
                    }

                }
            }
            ans++;
        }

        return -1;
    }
}