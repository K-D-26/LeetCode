class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if(l1 > l2)
            return false;
        
        int[] cnt = new int[26];
        for(int i=0; i<l1; i++) {
            cnt[s1.charAt(i) - 'a']++;
            cnt[s2.charAt(i) - 'a']--;
        }
        if(allZero(cnt))
            return true;
        
        for(int i=l1; i<l2; i++) {
            cnt[s2.charAt(i) - 'a']--;
            cnt[s2.charAt(i - l1) - 'a']++;
            if(allZero(cnt))
                return true;
        }
        return false;
    }
    
    private boolean allZero(int[] a) {
        for(int i : a)
            if(i != 0)
                return false;
        return true;
    }
}
