class Solution {
    int ans = 0;
    public int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        ans = Integer.MIN_VALUE;
        maxPathSumFromNode(root);
        return ans;
    }
    
    private int maxPathSumFromNode(TreeNode node) {
        if(node == null)
            return 0;
        int lsum = Math.max(0, maxPathSumFromNode(node.left));
        int rsum = Math.max(0, maxPathSumFromNode(node.right));
        ans = Math.max(ans, lsum + rsum + node.val);
        return Math.max(lsum, rsum) + node.val;
    }
}



// Terms used in code:

// lsum returns the maximum sum that can be gained by following the left side path of the node.
// Similarly, rsum returns maximum sum obtained by following the right side path of the node.
// If that maximum sum is negative, we will not take that path.
// We update the ans if the total sum obtained by moving from node's left to node's right is more than ans.
