class Solution {
    private long total = 0;
    private long ans = 0;
    public int maxProduct(TreeNode root) {
        if(root == null)
            return 0;
        count(root);
        sumOfSubTree(root);
        return (int)(ans % ((int)Math.pow(10, 9) + 7));
    }
    
    private void count(TreeNode root) {
        if(root == null)
            return;
        count(root.left);
        count(root.right);
        total += (long)root.val;
    }
    
    private long sumOfSubTree (TreeNode node) {
        if(node == null)
            return 0;
        long l = sumOfSubTree(node.left);
        long r = sumOfSubTree(node.right);
        long subTreeSum = l + r + node.val;
        ans = Math.max(ans, subTreeSum * (total - subTreeSum));
        return subTreeSum;
    }
}
