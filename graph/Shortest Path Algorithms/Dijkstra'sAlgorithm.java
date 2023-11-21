class Pair {
    int distance;
    int node;
    public Pair(int f, int s) {
        this.distance = f;
        this.node = s;
    }
}

class Solution {
    static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s) {
        // Using Priority Queue (min-heap):
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[] dist = new int[v];
        
        for (int i = 0; i < v; i++) {
            dist[i] = (int)(1e9);
        }
            
        dist[s] = 0;
        pq.add(new Pair(0, s));
        
        while(pq.size() != 0) {
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();
            for (int i = 0; i < adj.get(node).size(); i++) {
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        
        return dist;
    }
}