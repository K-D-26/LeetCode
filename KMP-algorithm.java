import java.util.*;

public class Solution {
    public static List<Integer> stringMatch(String text, String pattern) {
        // Pattern search using "KMP algorithm"

        int m = pattern.length(), n = text.length();
        List<Integer> ans = new ArrayList<>();

        // creating longest prefix suffix array
        int[] LPS = new int[m];
        int len = 0;
        for (int i = 1; i < m; i++) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                LPS[i] = len;
            }
            else {
                if (len != 0) {
                    len = LPS[len-1];
                }
            }
        }

        // using the lps array, we compare every character of pattern with the text
        int i = 0, j = 0;
        while (i < n) {
            // if the character matches, go on until it matches
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;

                // if the whole pattern is found, add the index to the 'ans' list
                if (j == m){
                    ans.add(i - j + 1);
                    j = LPS[j-1];
                } 
            }
            // else trace 'j' back to the position where the previous of j is pointing in the lps array.
            else {
                if (j > 0) {
                    j = LPS[j-1];
                }
                else {
                    i++;
                }
            }
        }

        return ans;
    }
}
