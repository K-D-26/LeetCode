class Solution {
    private int n = 26;
    public boolean closeStrings(String word1, String word2) {
        int[] a = new int[n];
        int[] b = new int[n];
        // Store count of each alphabet
        for(char c : word1.toCharArray())
            a[c-'a']++;
        for(char c : word2.toCharArray())
            b[c-'a']++;
        
        // return false if word1 has a alphabet that is not present in word2
        for(int i=0; i<n; i++) {
            if(a[i] == b[i])
                continue;
            if(a[i] == 0 || b[i] == 0)
                return false;
        }
        
        // Check if all the no. of occurences are same in both the words.
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i=0; i<n; i++)
            if(a[i] != b[i])
                return false;
        return true;
    }
}
