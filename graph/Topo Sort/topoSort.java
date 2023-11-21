class Solution {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] ans = new int[V];
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, st, adj);
            }
        }

        int i = 0;
        while (!st.isEmpty()) {
            ans[i++] = st.peek();
            st.pop();
        }
        
        return ans;
    }
    
    private static void dfs(int s, int[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        vis[s] = 1;
        for (int i : adj.get(s)) {
            if (vis[i] == 0) {
                dfs(i, vis, st, adj);
            }
        }

        st.push(s);
    }
}