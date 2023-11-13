class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // Iterative
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        
        while (true) {
            if (root != null) {
                st.push(root);
                root = root.left;           // go to left
            } 
            else {
                if (st.isEmpty()) break;
                
                root = st.peek();
                ans.add(root.val);          // add root
                st.pop();
                root = root.right;          // go to right
            }
        }
        
        return ans;
    }
}