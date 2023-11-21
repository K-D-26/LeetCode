class Solution {
    public boolean canFinish(int n, int[][] pre) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < pre.length; i++) {
            adj.get(pre[i][1]).add(pre[i][0]);
        }
        
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (Integer it : adj.get(i)) {
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        if (q.isEmpty()) return false;
        
        int[] ans = new int[n];
        int i = 0;
        
        while (!q.isEmpty()) {
            int node = q.peek();
            q.poll();
            ans[i++] = node;
            for (Integer it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }
        
        return (i == n) ? true : false;
    }
}