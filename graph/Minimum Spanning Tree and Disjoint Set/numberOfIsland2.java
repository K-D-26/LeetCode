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
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        Disjoint ds = new Disjoint(rows * cols);
        int[][] vis = new int[rows][cols];
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < operators.length; i++) {
            int r = operators[i][0];
            int c = operators[i][1];
            if (vis[r][c] == 1) {
                ans.add(cnt);
                continue;
            }
            vis[r][c] = 1;
            cnt++;
            
            int[] dr = {-1, 0, 1, 0};
            int[] dc = {0, 1, 0, -1};
            for (int j = 0; j < 4; j++) {
                int nr = r + dr[j];
                int nc = c + dc[j];
                if (isValid(nr, nc, rows, cols) && vis[nr][nc] == 1) {
                    int nodeNo = r*cols + c;
                    int adjNodeNo = nr*cols + nc;
                    if (ds.findUParent(nodeNo) != ds.findUParent(adjNodeNo)) {
                        cnt--;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
            
            ans.add(cnt);
        }
        
        return ans;
    }
    
    private boolean isValid(int r, int c, int m, int n) {
        return (r >= 0 && r < m && c >= 0 && c < n);
    }
}