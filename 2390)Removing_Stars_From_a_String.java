// Using StringBuilder

class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '*')
                sb.deleteCharAt(sb.length()-1);
            else
                sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}


// Using Stack + StringBuilder

class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '*')
                st.pop();
            else
                st.push(s.charAt(i));
        }
        if(st.size() == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        
        sb.reverse();
        
        return sb.toString();
    }
}
