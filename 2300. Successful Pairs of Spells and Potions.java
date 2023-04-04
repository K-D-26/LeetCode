class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] ans = new int[n];
        Arrays.sort(potions);
        
        for(int i=0; i<n; i++) {
            int l = 0;
            int h = m-1;
            while(l <= h) {
                int mid = (h-l)/2 + l;
                if((long)potions[mid]*spells[i] >= success) {
                    h = mid-1;
                }
                else {
                    l = mid+1;
                }
            }
            ans[i] = m - l;
        }
        
        return ans;
    }
}
