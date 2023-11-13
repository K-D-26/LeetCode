class NodeValue {
    public int minNode, maxNode, maxSize;
    
    public NodeValue(int min, int max, int size) {
        this.minNode = min;
        this.maxNode = max;
        this.maxSize = size;
    }
}

public class Solution {
    private static NodeValue helper(TreeNode node) {
        if (node == null) return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        
        NodeValue left = helper(node.left);
        NodeValue right = helper(node.right);
        
        // if current node's value is greater than the max value in left sub-tree and 
        // smaller than the min value in right sub-tree, it is a valid BST
        if (left.maxNode < node.data && node.data < right.minNode) {
            return new NodeValue(Math.min(node.data, left.minNode), Math.max(node.data, right.maxNode), 1 + left.maxSize + right.maxSize);
        }
        
        // else return NodeValue as (Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize)) 
        // so the parent can never be a valid BST.
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }

    public static int largestBST(TreeNode root) {
        return helper(root).maxSize;
    }
}