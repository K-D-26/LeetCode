class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (dfs(i, graph, color, 0) == false) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean dfs(int i, int[][] graph, int[] color, int col) {
        color[i] = col;
        for (int it : graph[i]) {
            if (color[it] == -1) {
                if (dfs(it, graph, color, 1-col) == false) {
                    return false;
                }
            }
            else if (color[it] == col) {
                return false;
            }
        }
        
        return true;
    }
}