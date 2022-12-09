// Method 1:
// This is simple and most intutive method to solve the problem, but as the size of tree increases, we will get TLE error for larger inputs.
class Solution {
    int v = 0;
    public int maxAncestorDiff(TreeNode root) {
        if(root == null)
            return v;
        if(root.left != null)
            diff(root, root.left);
        if(root.right != null)
            diff(root, root.right);
        return v;
    }
    
    private void diff(TreeNode a, TreeNode b) {
        int d = Math.abs(a.val - b.val);
        if(d > v)
            v = d;
        
        if(b.left != null)
            diff(a, b.left);
        if(b.right != null)
            diff(a, b.right);
        
        if(a.left != null && a.left.left != null)
            diff(a.left, a.left.left);
        if(a.left != null && a.left.right != null)
            diff(a.left, a.left.right);
        if(a.right != null && a.right.left != null)
            diff(a.right, a.right.left);
        if(a.right != null && a.right.right != null)
            diff(a.right, a.right.right);
    }
}



// Method 2:
// First we find the minimum and maximum values of the child and grandchild of a node, and then we take the difference between these children with the node and then update the value of v accordingly.
// We get minimum from the left side of a node and maximum from the right side of a node.
class Solution {
    private int v = 0;
    public int maxAncestorDiff(TreeNode root) {
        if(root == null)
            return v;
        maxDiff(root);
        return v;
    }
    
    private int[] maxDiff(TreeNode node) {
        if(node == null)
            return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
        
        int[] left = maxDiff(node.left);
        int[] right = maxDiff(node.right);
        
        int leftMin = left[0];
        int rightMin = right[0];
        int min = Math.min(node.val, Math.min(leftMin, rightMin));
        
        int leftMax = left[1];
        int rightMax = right[1];
        int max = Math.max(node.val, Math.max(leftMax, rightMax));
        
        v = Math.max(v, Math.max((max - node.val), (node.val - min)));
        return new int[] {min, max};
    }
}
