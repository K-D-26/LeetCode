// problem link: https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

// dfs

class Solution {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // dfs
        boolean[] vis = new boolean[V];
        for (int i=0; i<V; i++) {
            if (vis[i] == false) {
                if (dfs(adj, -1, i, vis)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(ArrayList<ArrayList<Integer>> adj, int p, int i, boolean[] vis) {
        vis[i] = true;
        for (Integer n : adj.get(i)) {
            if (vis[n] == false) {
                if (dfs(adj, i, n, vis)) {
                    return true;
                }
            }
            else if (n != p) {
                return true;
            }
        }
        
        return false;
    }
}


// bfs

class Solution {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // bfs
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                if (check(adj, i, vis)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean check(ArrayList<ArrayList<Integer>> adj, int i, boolean[] vis) {
        vis[i] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, -1});
        
        while (!q.isEmpty()) {
            int node = q.peek()[0];
            int parent = q.peek()[1];
            q.poll();
            for (Integer n : adj.get(node)) {
                if (vis[n] == false) {
                    vis[n] = true;
                    q.offer(new int[]{n, node});
                }
                else if (n != parent) {
                    return true;
                }
            }
        }
        
        return false;
    }
}