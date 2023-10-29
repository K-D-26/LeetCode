/* These are just normal solutions. For particlular alogrithm, refer its file. */


// Method 1:

class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}


// Method 2:

class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0) return -1;
        if (needle.length() == 0) return 0;
        
        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() > haystack.length()) break;
            
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) break;
                
                if (j == needle.length() - 1) return i;
            }
        }
        
        return -1;
    }
}
