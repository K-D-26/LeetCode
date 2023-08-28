// Method 1 (Using recursion):
// Time: O(n), Space: O(n)

class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}


// Method 2 (Using Stack):
// Time: O(n), Space: O(n)

class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        
        while(!st.isEmpty()) {
            TreeNode curr = st.pop();
            if(curr.right != null) {
                st.push(curr.right);
            }
            if(curr.left != null) {
                st.push(curr.left);
            }
            if(!st.isEmpty()) {
                curr.right = st.peek();
            }
            curr.left = null;
        }
    }
}


// Method 3 (Using Morris Traversal approach);
// Time: O(n), Space: O(1)

class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        TreeNode curr = root;
        while(curr != null) {
            if(curr.left != null) {
                TreeNode prev = curr.left;
                while(prev.right != null) {
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}
