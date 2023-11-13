class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        
        return isSymm(root.left, root.right);
    }
    
    private boolean isSymm(TreeNode a, TreeNode b) {
        if (a == null || b == null) return a == b;
        
        return (a.val == b.val) && isSymm(a.left, b.right) && isSymm(a.right, b.left);
    }
}