// The idea is to store the count of elements in both the strings and compare this count.
// If both the count are same, means one is an anagram of other.
// So, add the index in the list and at last return the list.

class Solution {
    public List<Integer> findAnagrams(String s1, String s2) {
        int s = s1.length(), p = s2.length();
        if(s < p)
            return new ArrayList<>();
        
        List<Integer> li = new ArrayList<>();
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        
        for(int i=0; i<p; i++) {
            c2[s2.charAt(i) - 'a']++;
            c1[s1.charAt(i) - 'a']++;
        }
        if(areEqual(c1, c2))
            li.add(0);
        
        for(int i=p; i<s; i++) {
            c1[s1.charAt(i-p) - 'a']--;
            c1[s1.charAt(i) - 'a']++;
            if(areEqual(c1, c2))
                li.add(i-p+1);
        }
        
        return li;
    }
    
    private boolean areEqual(int[] a, int[] b) {
        for(int i=0; i<26; i++)
            if(a[i] != b[i])
                return false;
        return true;
    }
}
