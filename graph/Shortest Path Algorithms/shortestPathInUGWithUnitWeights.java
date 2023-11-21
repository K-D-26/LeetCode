class Solution {
    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = (int)(1e9);
        }
        
        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        while (!q.isEmpty()) {
            int node = q.peek();
            q.poll();
            for (Integer i : adj.get(node)) {
                if (dist[node] + 1 < dist[i]) {
                    dist[i] = dist[node] + 1;
                    q.offer(i);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (dist[i] == (1e9)) {
                dist[i] = -1;
            }
        }
        
        return dist;
    }
}