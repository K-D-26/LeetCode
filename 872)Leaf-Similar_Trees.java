// We will travel to each node one-by-one and whenever we encounter a leaf node, we will return it in dfs.
// We maintain a stack of TreeNode's to traverse the tree.

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> s1  = new Stack<>(), s2 = new Stack<>();
        s1.push(root1);
        s2.push(root2);
        while(!s1.empty() && !s2.empty())
            if(dfs(s1) != dfs(s2))
                return false;
        return s1.empty() && s2.empty();
    }
    
    private int dfs(Stack<TreeNode> s) {
        while(true) {
            TreeNode node = s.pop();
            if(node.right != null)
                s.push(node.right);
            if(node.left != null)
                s.push(node.left);
            if(node.left == null && node.right == null)
                return node.val;
        }
    }
}
