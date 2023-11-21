class Pair {
    int adj;
    int wt;
    public Pair(int adj, int wt) {
        this.adj = adj;
        this.wt = wt;
    }
}

class Solution {
	public int[] shortestPath(int n, int m, int[][] edges) {
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
		    ArrayList<Pair> temp = new ArrayList<>();
		    adj.add(temp);
		}
		
		for (int i = 0; i < m; i++) {
		    int u = edges[i][0];
		    int v = edges[i][1];
		    int wt = edges[i][2];
		    adj.get(u).add(new Pair(v, wt));
		}
		
		int[] vis = new int[n];
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < n; i++) {
		    if (vis[i] == 0) {
		        topoSort(i, adj, vis, st);
		    }
		}
		
		int[] dist = new int[n];
		for (int i = 0; i < n; i++) {
		    dist[i] = (int)(1e9);
		}
	    dist[0] = 0;
	    
	    while(!st.isEmpty()) {
		    int node = st.peek();
		    st.pop();
	        for (int i = 0; i < adj.get(node).size(); i++) {
	            int v = adj.get(node).get(i).adj;
		        int wt = adj.get(node).get(i).wt;
		        if (dist[node] + wt < dist[v]) {
		            dist[v] = dist[node] + wt;
	            }
	        }
		}
		
		for (int i = 0; i < n; i++) {
		    if (dist[i] == 1e9) {
		        dist[i] = -1;
		    }
		}
		
		return dist;
	}
	
	private void topoSort(int i, ArrayList<ArrayList<Pair>> adj, int[] vis, Stack<Integer> st) {
	    vis[i] = 1;
	    for (int it = 0; it < adj.get(i).size(); it++) {
	        int v = adj.get(i).get(it).adj;
	        if (vis[v] == 0) {
	            topoSort(v, adj, vis, st);
	        }
	    }
	    st.push(i);
	}
}