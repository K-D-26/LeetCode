// Method 1 (Using HashMap):

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
            if(entry.getValue() > nums.length/2)
                return entry.getKey();
        
        return 0;
    }
}



// Method 2 (Optimized):

class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0, n = 0;
        for(int i : nums) {
            if(cnt == 0) {
                n = i;
                cnt++;
            }
            if(i == n)
                cnt++;
            else
                cnt--;
        }
        return n;
    }
}
