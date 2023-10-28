// Using stack:

class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int curr = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(curr);
                curr = 0;
            }
            else {
                curr = st.pop() + Math.max(curr * 2, 1);
            }
        }
        
        return curr;
    }
}


// Using constant space

class Solution {
    public int scoreOfParentheses(String s) {
        int ans = 0;
        int l = 0;          // layers - we count the no of layers for a complete parenthesis and then update the result.
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                l++;
            }
            else {
                l--;
            }
            
            if (s.charAt(i) == ')' && s.charAt(i-1) == '(') {
                ans += 1 << l;
            }
        }
        
        return ans;
    }
}
