class Solution {
    public int maxPathSum(TreeNode root) {
        int[] maxi = new int[1];
        maxi[0] = Integer.MIN_VALUE;
        int h = maxPathDown(root, maxi);
        
        return maxi[0];
    }

    private static int maxPathDown(TreeNode root, int[] maxi) {
        if (root == null) return 0;

        int l = Math.max(0, maxPathDown(root.left, maxi));
        int r = Math.max(0, maxPathDown(root.right, maxi));
        
        maxi[0] = Math.max(maxi[0], l + r + root.val);
        
        return Math.max(l, r) + root.val;
    }
}