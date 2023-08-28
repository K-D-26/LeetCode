class Solution {
    List<Integer> li = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return li;
    }
    
    public void inorder(TreeNode node) {
        if(node == null) return;
        
        inorder(node.left);
        li.add(node.val);
        inorder(node.right);
    }
}
