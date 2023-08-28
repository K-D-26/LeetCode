// Method 1: (Recursion)

class Solution {
    List<Integer> li = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return li;
    }
    
    public void inorder(TreeNode node) {
        if(node == null) return;
        
        inorder(node.left);
        li.add(node.val);
        inorder(node.right);
    }
}


// Method 2: (Morris Traversal)

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // Morris Traversal
        // Time: O(n), Space: O(1)
        
        TreeNode cur = root;
        List<Integer> ans = new ArrayList<>();
        
        while(cur != null) {
            if(cur.left == null) {
                ans.add(cur.val);
                cur = cur.right;
            }
            else {
                TreeNode lastRight = cur.left;      // last right node in the left sub-tree of cur
                while(lastRight.right != null && lastRight.right != cur) {
                    lastRight = lastRight.right;
                }
                // connect last right node of left sub-tree to it's root.
                if(lastRight.right == null) {
                    lastRight.right = cur;
                    cur = cur.left;
                }
                // after iterating the left part, break the connection.
                else {
                    lastRight.right = null;
                    ans.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        
        return ans;
    }
}
