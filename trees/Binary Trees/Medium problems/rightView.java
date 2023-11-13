class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        rightView(root, ans, 0);
        
        return ans;
    }
    
    private static void rightView(TreeNode node, List<Integer> ans, int currSize) {
        if (node == null) return;
        
        if (currSize == ans.size()) ans.add(node.val);
        
        rightView(node.right, ans, currSize + 1);
        rightView(node.left, ans, currSize + 1);
    }
}