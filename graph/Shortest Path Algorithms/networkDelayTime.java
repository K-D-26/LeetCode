class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] time : times) {
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});
        
        boolean[] vis = new boolean[n+1];
        int ans = 0;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.peek();
            pq.poll();
            int currTime = curr[0];
            int currNode = curr[1];
            
            if (vis[currNode]) continue;

            vis[currNode] = true;
            ans = currTime;
            n--;
            if (map.containsKey(currNode)) {
                for (int next : map.get(currNode).keySet()) {
                    pq.add(new int[]{currTime + map.get(currNode).get(next), next});
                }
            }
        }
        
        return n == 0 ? ans : -1;
    }
}