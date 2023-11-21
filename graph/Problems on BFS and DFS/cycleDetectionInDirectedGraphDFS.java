class Solution {
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[v];
        int[] pathVis = new int[v];
        
        for (int i = 0; i < v; i++) {
            if (vis[i] == 0) {
                if (dfs(i, adj, vis, pathVis)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(int i, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathVis) {
        vis[i] = 1;
        pathVis[i] = 1;
        
        for (Integer it : adj.get(i)) {
            if (vis[it] == 0) {
                if (dfs(it, adj, vis, pathVis)) {
                    return true;
                }
            }
            else if (pathVis[it] == 1) {
                return true;
            }
        }
        
        pathVis[i] = 0;
        return false;
    }
}