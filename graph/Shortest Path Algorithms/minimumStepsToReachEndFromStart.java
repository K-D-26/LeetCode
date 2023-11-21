// minimum steps to reach end from start by doing multiplication and mod

class Pair {
    int first;
    int second;
    public Pair(int a, int b) {
        this.first = a;
        this.second = b;
    }
}

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        if (start == end) {
            return 0;
        }
        
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(start, 0));
        int[] dist = new int[100000];

        for (int i = 0; i < 100000; i++) {
            dist[i] = (int)(1e9);
        }

        dist[start] = 0;
        int mod = 100000;
        
        while (!q.isEmpty()) {
            int node = q.peek().first;
            int steps = q.peek().second;
            q.poll();
            for (int i = 0; i < arr.length; i++) {
                int num = (arr[i] * node) % mod;
                if (steps + 1 < dist[num]) {
                    dist[num] = steps + 1;
                    if (num == end) {
                        return steps + 1;
                    }
                    q.offer(new Pair(num, steps + 1));
                }
            }
        }
        
        return -1;
    }
}