class Solution {
    public int evalRPN(String[] tokens) {
        int m, n;
		Stack<Integer> st = new Stack<Integer>();
		for(String s : tokens) {
			if(s.equals("+"))
				st.add(st.pop()+st.pop());

			else if(s.equals("-")) {
				n = st.pop();
				m = st.pop();
				st.add(m-n);
			}
            
			else if(s.equals("*"))
				st.add(st.pop() * st.pop());
			
            else if(s.equals("/")) {
				n = st.pop();
				m = st.pop();
				st.add(m/n);
			}
			
            else
				st.add(Integer.parseInt(s));
		}	
		return st.pop();
    }
}
