class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        // Morris Traversal
        // Time: O(n), Space: O(1)
        
        TreeNode cur = root;
        List<Integer> ans = new ArrayList<>();
        
        while (cur != null) {
            if (cur.left == null) {
                ans.add(cur.val);
                cur = cur.right;
            }
            else {
                // last right node in the left sub-tree of cur
                TreeNode lastRight = cur.left;
                while(lastRight.right != null && lastRight.right != cur) {
                    lastRight = lastRight.right;
                }
                
                // connect last right node of left sub-tree to it's root.
                if(lastRight.right == null) {
                    lastRight.right = cur;
                    ans.add(cur.val);
                    cur = cur.left;
                }
                
                // after iterating the left part, break the connection.
                else {
                    lastRight.right = null;
                    cur = cur.right;
                }
            }
        }
        
        return ans;
    }
}