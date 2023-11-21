class Pair {
    int first;
    int second;
    public Pair(int a, int b) {
        this.first = a;
        this.second = b;
    }
}

class Disjoint {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    public Disjoint(int n) {
        for (int i = 0; i < n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    
    public int findUParent(int node) {
        if (parent.get(node) == node) {
            return node;
        }
        
        int ulp = findUParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    
    public void unionByRank(int u, int v) {
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);

        if (ulp_u == ulp_v) return;
        
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        }
        else if (rank.get(ulp_u) > rank.get(ulp_v)) {
            parent.set(ulp_v, ulp_u);
        }
        else {
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u) + 1);
        }
    }
    
    public void unionBySize(int u, int v) {
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);

        if (ulp_u == ulp_v) return;
        
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }
        else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Edge implements Comparable<Edge> {
    int src;
    int dst;
    int wt;
    Edge(int s, int d, int w) {
        this.src = s;
        this.dst = d;
        this.wt = w;
    }
    
    public int compareTo(Edge compareEdge) {
        return this.wt - compareEdge.wt;
    }
}

class Solution {
	static int spanningTree(int V, int E, int edgesGraph[][]) {
	    // Kruskal's algorithm
	    
	    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	    for (int i = 0; i < V; i++) {
	        adj.add(new ArrayList<>());
	    }
	    
	    for (int i = 0; i < edgesGraph.length; i++) {
	        adj.get(edgesGraph[i][0]).add(new Pair(edgesGraph[i][1], edgesGraph[i][2]));
	        adj.get(edgesGraph[i][1]).add(new Pair(edgesGraph[i][0], edgesGraph[i][2]));
	    }
	    
	    List<Edge> edges = new ArrayList<>();
	    for (int i = 0; i < V; i++) {
	        for (Pair p : adj.get(i)) {
	            int adjNode = p.first;
	            int edWt = p.second;
	            edges.add(new Edge(i, adjNode, edWt));
	        }
            // for (int j=0; j<adj.get(i).size(); j++) {
            //     int node = i;
            //     int adjNode = adj.get(i).get(j).first;
            //     int edWt = adj.get(i).get(j).second;
            //     Edge temp = new Edge(node, adjNode, edWt);
            //     edges.add(temp);
            // }
	    }
	    
	    Disjoint ds = new Disjoint(V);
	    Collections.sort(edges);
	    int mstWt = 0;
	    
	    for (int i = 0; i < edges.size(); i++) {
	        int u = edges.get(i).src;
	        int v = edges.get(i).dst;
	        int w = edges.get(i).wt;
	        if (ds.findUParent(u) != ds.findUParent(v)) {
	            mstWt += w;
	            ds.unionBySize(u, v);
	        }
	    }
	    
	    return mstWt;
	}
}