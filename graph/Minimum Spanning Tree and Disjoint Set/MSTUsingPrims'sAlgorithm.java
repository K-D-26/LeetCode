class Pair {
    int first;
    int second;
    public Pair(int a, int b) {
        this.first = a;
        this.second = b;
    }
}

class Solution {
	static int spanningTree(int V, int E, int edges[][]) {
	    // Prim's algorithm
	    PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);
	    pq.add(new Pair(0, 0));     // Pair -> {wt, node}
	    int[] vis = new int[V];
	    int sum = 0;
	    
	    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	    for (int i = 0; i < V; i++) {
	        adj.add(new ArrayList<>());
	    }
	    
	    for (int i = 0; i < edges.length; i++) {
	        adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
	        adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
	    }
	    
	    while(!pq.isEmpty()) {
	        int wt = pq.peek().first;
	        int node = pq.peek().second;
	        pq.poll();

	        if (vis[node] == 1) continue;
	        
			vis[node] = 1;
	        sum += wt;
	        for (Pair p : adj.get(node)) {
	            int edWt = p.second;
	            int adjNode = p.first;
	            if (vis[adjNode] == 0) {
	                pq.offer(new Pair(edWt, adjNode));
	            }
	        }
            // for (int i = 0; i < adj.get(node).size(); i++) {
            //     int edWt = adj.get(node).get(i).second;
            //     int adjNode = adj.get(node).get(i).first;
            //     if (vis[adjNode] == 0) {
            //         pq.offer(new Pair(edWt, adjNode));
            //     }
            // }
	    }
	    
	    return sum;
	}
}