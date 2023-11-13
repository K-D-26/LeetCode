class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) return helper(root);
        
        TreeNode dummy = root;
        while (root != null) {
            if (root.val > key) {
                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;
                }
                else {
                    root = root.left;
                }
            }
            else {
                if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;
                }
                else {
                    root = root.right;
                }
            }
        }
        
        return dummy;
    }
    
    private static TreeNode findLastRight(TreeNode node) {
        if (node.right == null) return node;
        return findLastRight(node.right);
    }
    
    private static TreeNode helper(TreeNode node) {
        if (node.left == null) return node.right;
        if (node.right == null) return node.left;
        
        TreeNode rightChild = node.right;
        TreeNode lastRight = findLastRight(node.left);
        lastRight.right = rightChild;
        
        return node.left;
    }
}