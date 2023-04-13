// Method 1:

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int j = 0;
        
        for(int i=0; i<pushed.length; i++) {
            if(st.isEmpty() || st.peek() != popped[j])
                st.push(pushed[i]);
            else {
                while(st.size() > 0 && st.peek() == popped[j]) {
                    st.pop();
                    j++;
                }
                st.push(pushed[i]);
            }
        }
        
        while(st.size() > 0 && st.peek() == popped[j]) {
            st.pop();
            j++;
        }
        
        return st.isEmpty();
    }
}


// Method 2:

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int j = 0;
        
        for(int i=0; i<pushed.length; i++) {
            st.push(pushed[i]);
            while(st.size() > 0 && st.peek() == popped[j]) {
                st.pop();
                j++;
            }
        }
        
        return st.isEmpty();
    }
}
