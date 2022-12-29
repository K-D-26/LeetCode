class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] ans = new int[n];
        
        // Creating a table for each task. 
        // First column --> index
        // Second column --> task's enqueuing time
        // Third column --> task's processing time
        int[][] table = new int[n][3];
        for(int i=0; i<n; i++) {
            table[i][0] = i;
            table[i][1] = tasks[i][0];
            table[i][2] = tasks[i][1];
        }
        
        Arrays.sort(table, (a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]);
        int time = 0, i = 0, j = 0;        
        while(i < n) {
            while(j < n && table[j][1] <= time)
                pq.offer(table[j++]);
            
            if(pq.isEmpty()) {
                time = table[j][1];
                continue;
            }
            
            // Get the task that is completed first and add it's index to the ans array. Also add the time taken by the task to complete.
            int[] completed = pq.poll();
            ans[i++] = completed[0];
            time += completed[2];
        }
        return ans;
    }
}
