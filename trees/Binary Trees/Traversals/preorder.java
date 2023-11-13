class Solution {
    List<Integer> ans = new ArrayList<>();
    
    public List<Integer> preorderTraversal(TreeNode root) {
        // recursive
        preorder(root);
        return ans;
    }
    
    private void preorder(TreeNode node) {
        if (node == null) return;
        
        ans.add(node.val);
        preorder(node.left);        // go to left
        preorder(node.right);       // go to right
    }
}