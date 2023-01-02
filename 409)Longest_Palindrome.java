class Solution {
    public int longestPalindrome(String s) {
        int[] cap = new int[26];
        int[] sma = new int[26];
        int ans = 0;
        int capOddCnt = 0, smaOddCnt = 0;
        
        for(char c : s.toCharArray()) {
            if(Character.isUpperCase(c))
                cap[c-'A']++;
            else
                sma[c-'a']++;
        }
        
        for(int i=0; i<26; i++) {
            if(cap[i] %2 == 0)
                ans += cap[i];
            if(sma[i] %2 == 0)
                ans += sma[i];
            if(cap[i] %2 != 0) {
                capOddCnt++;
                ans += cap[i];
            }
            if(sma[i] %2 != 0) {
                smaOddCnt++;
                ans += sma[i];
            }
        }
        
        if(capOddCnt > 0 || smaOddCnt > 0)
            ans = ans - capOddCnt - smaOddCnt + 1;
        
        return ans;
    }
}
