// Using for loop: (1 ms)

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        List<Boolean> list = new ArrayList();
        
        int max = candies[0];
        for(int i=1; i<candies.length; i++) {
            if(max < candies[i]) {
                max = candies[i];
            }
        }
        for(int i=0; i<candies.length; i++) {
            candies[i] += extraCandies;
            if(candies[i] >= max) {
                 list.add(true);
            }
            else {
                 list.add(false);
            }
        }
        return list;
    }
}


// Using for - each loop: (1 ms)

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for(int i : candies)
            max = Math.max(max, i);
        
        List<Boolean> ans = new ArrayList<>(candies.length);
        for(int i : candies) {
            if(i + extraCandies >= max)
                ans.add(true);
            else
                ans.add(false);
        }
        
        return ans;
    }
}
