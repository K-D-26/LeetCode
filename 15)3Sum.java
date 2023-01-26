// Method 1:

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        int sum = 0;
        
        for(int i=0; i<nums.length && nums[i] <= 0; i++) {
            int j = i+1;
            int k = nums.length-1;
            while(j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if(sum == 0)
                    set.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                else if(sum > 0)
                    k--;
                else
                    j++;
            }
        }
        
        return new ArrayList<>(set);
    }
}




// Method 2 (Optimized):

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length && nums[i] <= 0; i++)
            if (i == 0 || nums[i-1] != nums[i])
                twoSum(nums, i, res);
                
        return res;
    }

    public void twoSum(int[] nums, int i, List<List<Integer>> res) {
        int j = i+1, k = nums.length-1;
        while (j < k) {
            int sum =  nums[i] + nums[j] + nums[k];
            if(sum == 0) {
                res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                j++;
                k--;
                while (j < k && nums[j-1] == nums[j]) {
                    j++;
                }
            }
            else if(sum > 0) {
                k--;
            }
            else
                j++;
        }
    }
}    
