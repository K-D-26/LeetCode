// Method 1 (Using HashMap):

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> li = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int m = nums.length/3;
        
        for(int i : nums)
            map.put(i, map.getOrDefault(i, 0)+1);
        
        for(Map.Entry<Integer, Integer> e : map.entrySet())        
            if(e.getValue() > m)
                li.add(e.getKey());
        
        return li;
    }
}

// Time complexity: O(n*logn)
// Space complexity: O(n)

// Note: You can improve the time complexity here using a frequency array.



// Method 2 (Optimized):

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> li = new ArrayList<>();
        int n1 = -1, n2 = -1, c1 = 0, c2 = 0;
        
        for(int i : nums) {
            if(i == n1)
                c1++;
            else if(i == n2)
                c2++;
            else if(c1 == 0) {
                n1 = i;
                c1++;
            }
            else if(c2 == 0) {
                n2 = i;
                c2++;
            }
            else {
                c1--;
                c2--;
            }
        }
        
        c1 = 0;
        c2 = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == n1)
                c1++;
            else if(nums[i] == n2)
                c2++;
        }
        
        if(c1 > nums.length/3)
            li.add(n1);
        if(c2 > nums.length/3)
            li.add(n2);
        
        return li;
    }
}

// Time complexity: O(n)
// Space complexity: O(1)
