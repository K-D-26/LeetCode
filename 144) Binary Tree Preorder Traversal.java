class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> li = new ArrayList<>();
        preOrder(root, li);
        return li;
    }
    
    private void preOrder(TreeNode node, List<Integer> li) {
        if(node == null) return;
        li.add(node.val);
        preOrder(node.left, li);
        preOrder(node.right, li);
    }
}
