class Solution {
    public String findOrder(String [] dict, int n, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n-1; i++) {
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }
            }
        }
        
        List<Integer> topo = topoSort(k, adj);
        String ans = "";
        for (int i : topo) {
            ans += (char)(i + (int)'a');
        }
        
        return ans;
    }
    
    private List<Integer> topoSort(int n, List<List<Integer>> adj) {
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.peek();
            q.poll();
            ans.add(node);
            for (Integer i : adj.get(node)) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }
        }
        
        return ans;
    }
}