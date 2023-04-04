class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, h = people.length-1;
        int ans = 0;
        while(l <= h) {
            if(l == h) {
                ans++;
                break;
            }
            if(people[h] + people[l] > limit)
                h--;
            else {
                l++;
                h--;
            }
            ans++;
        }
        return ans;
    }
}
