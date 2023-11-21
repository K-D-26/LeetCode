class Pair {
    int node;
    int price;
    public Pair(int a, int b) {
        this.node = a;
        this.price = b;
    }
}

class tuple {
    int stops;
    int city;
    int cost;
    public tuple(int a, int b, int c) {
        this.stops = a;
        this.city = b;
        this.cost = c;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        int m = flights.length;
        for (int i = 0; i < m; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        
        Queue<tuple> q = new LinkedList<>();
        q.offer(new tuple(0, src, 0));
        int[] dist = new int[n];
        Arrays.fill(dist, (int)(1e9));
        dist[src] = 0;
        
        while (!q.isEmpty()) {
            tuple t = q.peek();
            q.poll();
            int stops = t.stops;
            int node = t.city;
            int cost = t.cost;
            
            if (stops > k) {
                continue;
            }
            
            for (Pair p : adj.get(node)) {
                int adjNode = p.node;
                int edWt = p.price;
                if (cost + edWt < dist[adjNode] && stops <= k) {
                    dist[adjNode] = cost + edWt;
                    q.offer(new tuple(stops+1, adjNode, dist[adjNode]));
                }
            }
        }
        
        return (dist[dst] == (1e9)) ? -1 : dist[dst];
    }
}