class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length < 2)
            return true;
        int pos = 0;
        for(int i=0; i<nums.length-1 && pos>=i; i++) {
            pos = Math.max(pos, i+nums[i]);
            if(pos >= nums.length-1)
                return true;
        }
        return false;
    }
}
