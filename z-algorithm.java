import java.util.*;
public class Solution {
    public static List<Integer> search(String text, String pattern) {
        // Pattern search using "Z - algorithm"

        int patLen = pattern.length();
        int txtLen = text.length();
        List<Integer> ans = new ArrayList<>();
        // create a new string containing pattern and text, separated by #.
        String newString = pattern + "#" + text;
        List<Integer> z = new ArrayList<>();

        int i = 0;
        while (i < newString.length()) {
            // till hash, add 0 to the list 'z'
            if (i <= patLen) z.add(0);
            else {
                int left = 0, right = 0;
                // further where the first character or the pattern matches with any index of the text,
                // we check upto how many characters it is getting matched,
                // then add the count of characters that matched with the pattern to the list 'z'
                if (newString.charAt(left) == newString.charAt(i)) {
                    right = i;
                    while (right < newString.length() && newString.charAt(left) == newString.charAt(right)) {
                        left++;
                        right++;
                    }
                }
                z.add(left);
            }
            i++;
        }

        // now, we check the 'z' list. Wherever we get the value in the list equal to the pattern's length, 
        // it means at that index we have got a substring which is equal to the pattern. So, we add it to the 'ans' list.
        for (int j = 0; j < newString.length(); j++) {
            if (z.get(j) == patLen) {
                ans.add(j - patLen);
            }
        }

        return ans;
    }
}
