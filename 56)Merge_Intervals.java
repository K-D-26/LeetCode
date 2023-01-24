class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length < 2)
            return intervals;
        
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1; i<intervals.length; i++) {            
            if(intervals[i][0] <= end)
                end = Math.max(intervals[i][1], end);
            else {
                ans.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        ans.add(new int[]{start, end});        
        return ans.toArray(new int[0][]);
    }
}
