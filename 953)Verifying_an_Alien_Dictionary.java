class Solution {
    int[] mapping = new int[26];
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length == 1)
            return true;
        
        // Storing the lexicographical order of alphabets in alien language        
        for(int i=0; i<26; i++)
            mapping[order.charAt(i)-'a'] = i;
        
        for(int i=1; i<words.length; i++)
            if(notInOrder(words[i-1], words[i]))
                return false;
        
        return true;
    }
    
    private boolean notInOrder(String a, String b) {
        int m = a.length();
        int n = b.length();
        
        for(int i=0; i<m && i<n; ++i)
            if(a.charAt(i) != b.charAt(i))
                return mapping[a.charAt(i)-'a'] > mapping[b.charAt(i)-'a'];
        
        return m > n;
    }
}
