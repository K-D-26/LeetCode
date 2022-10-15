// Method 1:
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


// Method 2: 
class Solution {
    public boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length;
    }
}


// Method 3:
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i : nums)
            if(!set.add(i))// if there is same
                return true; 
        return false;
    }
}
