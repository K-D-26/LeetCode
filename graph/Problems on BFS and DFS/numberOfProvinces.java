class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] != 0 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        
        int cnt = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                cnt++;
                dfs(adjList, i, vis);
            }
        }
        
        return cnt;
    }
    
    private void dfs(ArrayList<ArrayList<Integer>> list, int i, boolean[] vis) {
        vis[i] = true;
        for (Integer n : list.get(i)) {
            if (!vis[n]) {
                dfs(list, n, vis);
            }
        }
    }
}