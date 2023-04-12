class Solution {
    public int minimizeArrayValue(int[] nums) {
        int l = 0, r = Arrays.stream(nums).max().getAsInt();
        int ans = 0;
        
        while(l <= r) {
            int mid = (l+r)/2;
            if(valid(mid, nums)) {
                ans = mid;
                r = mid-1;
            }
            else
                l = mid+1;
        }
        
        return ans;
    }
    
    private static boolean valid(int mid, int[] nums) {
        long sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(sum > (long)mid * (i+1))
                return false;
        }
        
        return true;
    }
}
