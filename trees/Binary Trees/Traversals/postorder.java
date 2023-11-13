// Method 1 (Using 2 stacks):

class Solution {
    public List<Integer> postorderTraversal(TreeNode curr) {
        // iterative: Using 2 Stacks
        
        List<Integer> postOrder = new ArrayList<>();
        if (curr == null) return postOrder;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        
        s1.push(curr);
        while (!s1.isEmpty()) {
            curr = s1.peek();
            s1.pop();
            s2.push(curr);
            if (curr.left != null) s1.push(curr.left);
            if (curr.right != null) s1.push(curr.right);
        }
        
        while (!s2.isEmpty()) {
            postOrder.add(s2.peek().val);
            s2.pop();
        }
        
        return postOrder;
    }
}


// Method 2 (Using just 1 stack):

class Solution {
    public List<Integer> postorderTraversal(TreeNode cur) {
        // recursive: Using 1 Stack
        
        List<Integer> postOrder = new ArrayList<>();
        if (cur == null) return postOrder;

        Stack<TreeNode> st = new Stack<>();
        while (cur != null || !st.isEmpty()) {
            if (cur != null) {
                st.push(cur);
                cur = cur.left;
            } 
            else {
                TreeNode temp = st.peek().right;
                if (temp == null) {
                    temp = st.peek();
                    st.pop();
                    postOrder.add(temp.val);
                    while (!st.isEmpty() && temp == st.peek().right) {
                        temp = st.peek();
                        st.pop();
                        postOrder.add(temp.val);
                    }
                }
                else {
                    cur = temp;
                }
            }
        }
        
        return postOrder;
    }
}