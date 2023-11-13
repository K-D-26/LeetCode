class BSTIterator {
    private static Stack<TreeNode> st = new Stack<>();
    
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        TreeNode node = st.pop();
        pushAll(node.right);

        return node.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
    
    private static void pushAll(TreeNode node) {
        while (node != null) {
            st.push(node);
            node = node.left;
        }
    }
}