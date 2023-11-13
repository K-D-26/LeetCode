class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxi = new int[1];
        int h = maxDepth(root, maxi);
        return maxi[0];
    }
    
    private static int maxDepth(TreeNode root, int[] maxi) {
        if (root == null) return 0;
        
        int left = maxDepth(root.left, maxi);
        int right = maxDepth(root.right, maxi);
        
        maxi[0] = Math.max(maxi[0], left + right);
        return Math.max(left, right) + 1;
    }
}