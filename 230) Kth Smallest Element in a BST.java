// Method 1:

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if(k <= count) {
            return kthSmallest(root.left, k);
        }
        else if(k > count + 1) {
            return kthSmallest(root.right, k-1-count);  // 1 is counted as current node
        }
        return root.val;
    }
    
    public int countNodes(TreeNode n) {
        if(n == null) return 0;
        return 1 + countNodes(n.left) + countNodes(n.right);
    }
}


// Method 2:

class Solution {
    private int count = 0;
    private int result = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }
    
    private void traverse(TreeNode node, int k) {
        if(node == null) return;
        
        traverse(node.left, k);
        count++;
        if(count == k) {
            result = node.val;
            return;
        }
        traverse(node.right, k);
    }
}
