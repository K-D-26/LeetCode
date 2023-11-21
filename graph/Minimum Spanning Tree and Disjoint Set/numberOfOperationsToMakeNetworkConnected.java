// Method 1 (DFS):

class Solution {
    public static int minimumConnections(int n, int[][] connections) {
        if (connections.length < n-1) {
            return -1;
        }
        
        List<List<Integer>> li = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            li.add(new ArrayList<>());
        }
        
        for (int[] a : connections) {
            li.get(a[0]).add(a[1]);
            li.get(a[1]).add(a[0]);
        }
        
        int[] vis = new int[n];
        int comp = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, li);
                comp++;
            }
        }
        
        return comp-1;
    }
    
    private static void dfs(int s, int[] vis, List<List<Integer>> li) {
        vis[s] = 1;
        for (int a : li.get(s)) {
            if (vis[a] == 0) {
                dfs(a, vis, li);
            }
        }
    }
}


// Method 2 (MST):

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

class Solution {
    public static int minimumConnections(int n, int[][] connections) {
        if (connections.length < n-1) {
            return -1;
        }
        
        Disjoint ds = new Disjoint(n);
        int cntExtras = 0;
        
        for (int i = 0; i < connections.length ; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            if (ds.findUParent(u) == ds.findUParent(v)) {
                cntExtras++;
            }
            else {
                ds.unionBySize(u, v);
            }
        }
        
        int cntC = 0;
        for (int i = 0; i < n; i++) {
            if (ds.parent.get(i) == i) {
                cntC++;
            }
        }
        
        int ans = cntC - 1;
        if (cntExtras >= ans) {
            return ans;
        }

        return -1;
    }
}