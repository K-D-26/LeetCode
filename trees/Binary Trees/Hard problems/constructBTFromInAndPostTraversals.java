class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inMap);
    }
    
    private static TreeNode helper(int[] in, int inStart, int inEnd, int[] post, int postStart, int postEnd, Map<Integer, Integer> map) {
        if (inStart > inEnd || postStart > postEnd) return null;
        
        TreeNode root = new TreeNode(post[postEnd]);
        int inRoot = map.get(root.val);
        int numsLeft = inRoot - inStart;
        
        root.left = helper(in, inStart, inRoot - 1, post, postStart, postStart + numsLeft - 1, map);
        root.right = helper(in, inRoot + 1, inEnd, post, postStart + numsLeft, postEnd - 1, map);
        
        return root;
    }
}