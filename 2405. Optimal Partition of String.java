class Solution {
    public int partitionString(String s) {
        int i = 0, ans = 0;
        Set<Character> set = new HashSet<>();
        
        while(i < s.length()) {
            for(; i<s.length(); i++) {
                if(!set.contains(s.charAt(i))) {
                    set.add(s.charAt(i));
                }
                else {
                    ans++;
                    set.clear();
                    set.add(s.charAt(i));
                }
            }
        }
        
        if(set.size() > 0)
            ans++;
        
        return ans;
    }
}
