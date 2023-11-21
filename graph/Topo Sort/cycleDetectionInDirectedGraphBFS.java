class Solution {
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        // Topological sort
        int[] inDegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (Integer it : adj.get(i)) {
                inDegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        
        int count = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.poll();
            count++;
            for (Integer it : adj.get(node)) {
                inDegree[it]--;
                if (inDegree[it] == 0) {
                    q.offer(it);
                }
            }
        }
        
        return !(count == v);
    }
}