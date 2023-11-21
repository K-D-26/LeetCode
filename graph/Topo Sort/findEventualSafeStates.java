// Method 1 (DFS):

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // dfs
        int n = graph.length;
        int[] vis = new int[n];
        int[] pathVis = new int[n];
        int[] check = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, graph, vis, pathVis, check);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (check[i] == 1) {
                ans.add(i);
            }
        }
        
        return ans;
    }
    
    private boolean dfs(int i, int[][] adj, int[] vis, int[] pathVis, int[] check) {
        vis[i] = 1;
        pathVis[i] = 1;
        check[i] = 0;
        
        for (int it : adj[i]) {
            if (vis[it] == 0) {
                if (dfs(it, adj, vis, pathVis, check)) {
                    return true;
                }
            }
            else if (pathVis[it] == 1) {
                return true;
            }
        }
        
        check[i] = 1;
        pathVis[i] = 0;
        return false;
    }
}


// Method 2 (Topo Sort):

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // Reverse all the edges
        List<List<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            revAdj.add(new ArrayList<>());
        }

        int[] indegree = new int[graph.length];
        List<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < graph.length; i++) {
            for (int it : graph[i]) {
                revAdj.get(it).add(i);
                indegree[i]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        if (q.isEmpty()) return ans;
        
        while (!q.isEmpty()) {
            int node = q.peek();
            q.poll();
            ans.add(node);
            for (int it : revAdj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }
        
        Collections.sort(ans);
        return ans;
    }
}