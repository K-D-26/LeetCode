class Solution {
    public ArrayList<Integer> dfsOfGraph(int n, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[n];
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(adj, n, 0, vis, ans);
            }
        }
        
        return ans;
    }
    
    private static void dfs(ArrayList<ArrayList<Integer>> adj, int n, int i, int[] vis, ArrayList<Integer> ans) {
        vis[i] = 1;
        ans.add(i);
        
        for (Integer ind : adj.get(i)) {
            if (vis[ind] == 0) {
                dfs(adj, n, ind, vis, ans);
            }
        }
    }
}