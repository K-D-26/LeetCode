// Using 2 variables for iterating:

class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuffer ans = new StringBuffer();
        int n = word1.length(), m = word2.length(), i = 0, j = 0;
        while(i < n && j < m) {
            ans.append(word1.charAt(i++));
            ans.append(word2.charAt(j++));
        }
        if(i < n)
            ans.append(word1.substring(i));
        else
            ans.append(word2.substring(j));
        
        return ans.toString();
    }
}


// Using just 1 variable for iterating:

class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuffer ans = new StringBuffer();
        int i = 0;
        while(i < word1.length() && i < word2.length()) {
            ans.append(word1.charAt(i));
            ans.append(word2.charAt(i++));
        }
        if(i < word1.length())
            ans.append(word1.substring(i));
        else
            ans.append(word2.substring(i));
        
        return ans.toString();
    }
}
