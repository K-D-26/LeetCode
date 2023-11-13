class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        
        TreeNode root = helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        
        return root;
    }
    
    private TreeNode helper(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(pre[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;
        
        root.left = helper(pre, preStart + 1, preStart + numsLeft, in, inStart, inRoot - 1, inMap);
        root.right = helper(pre, preStart + numsLeft + 1, preEnd, in, inRoot + 1, inEnd, inMap);
        
        return root;
    }
}