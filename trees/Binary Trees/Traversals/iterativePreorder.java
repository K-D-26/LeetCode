class Solution {
    public List<Integer> preorderTraversal(TreeNode curr) {
        // Iterative
        List<Integer> preOrder = new ArrayList<>();
        if (curr == null) return preOrder;

        Stack<TreeNode> st = new Stack<>();
        st.push(curr);

        while(!st.isEmpty()) {
            TreeNode topNode = st.peek();
            // add root value to ans list
            preOrder.add(topNode.val);
            st.pop();
            
            // first we add right node to the stack and then left, 
            // so when we pop the node, we first get the left node and then we get the right node
            if (topNode.right != null) st.push(topNode.right);
            
            if (topNode.left != null) st.push(topNode.left);
        }
        
        return preOrder;
    }
}