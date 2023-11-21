class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int s) {
        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = (int)(1e8);
        }
        dist[s] = 0;
        
        for (int i = 0; i < V-1; i++) {
            for (ArrayList<Integer> li : edges) {
                int u = li.get(0);
                int v = li.get(1);
                int wt = li.get(2);
                if (dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        
        for (ArrayList<Integer> li : edges) {
            int u = li.get(0);
            int v = li.get(1);
            int wt = li.get(2);
            if (dist[v] != (int)(1e8) && dist[u] + wt < dist[v]) {
                return new int[]{-1};
            }
        }
        
        return dist;
    }
}