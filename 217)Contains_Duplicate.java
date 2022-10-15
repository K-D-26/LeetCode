class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length < 2)
            return false;
        
        Arrays.sort(nums);
        int i = 0, j = 1;
        while(i != nums.length && j != nums.length) {
            if(nums[i] == nums[j])
                return true;
            if(i < j)
                i += 2;
            else
                j += 2;
        }
        return false;
    }
}
