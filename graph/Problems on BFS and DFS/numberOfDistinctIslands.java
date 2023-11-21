// problem link: https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1

class Pair {
    int first;
    int second;
    public Pair(int f, int s) {
        this.first = f;
        this.second = s;
    }
}

class Solution {
    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        Set<ArrayList<String>> s = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    ArrayList<String> vec = new ArrayList<>();
                    dfs(i, j, vis, grid, vec, i, j);
                    s.add(vec);
                }
            }
        }
        
        return s.size();
    }
    
    private static void dfs(int row, int col, int[][] vis, int[][] grid, ArrayList<String> vec, int row0, int col0) {
        vis[row][col] = 1;
        vec.add(toString(row-row0, col-col0));
        int n = grid.length;
        int m = grid[0].length;
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        
        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, vis, grid, vec, row0, col0);
            }
        }
    }
    
    private static String toString(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }
}