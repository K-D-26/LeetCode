class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] needed = new int[rocks.length];
        for(int i=0; i<rocks.length; i++)
            needed[i] = capacity[i]-rocks[i];
        
        Arrays.sort(needed);
        int j = 0;
        
        while(additionalRocks >= needed[j]) {
            additionalRocks -= needed[j++];
            if(j == needed.length)
                break;
        }
        
        return j;
    }
}
