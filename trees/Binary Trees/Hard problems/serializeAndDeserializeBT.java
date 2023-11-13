public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        q.offer(root);
        
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                ans.append("n ");
            }
            else {
                ans.append(node.val + " ");
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        
        return ans.toString();
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.offer(root);
        
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.valueOf(values[i]));
                parent.left = left;
                q.offer(left);
            }
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.valueOf(values[i]));
                parent.right = right;
                q.offer(right);
            }
        }
        
        return root;
    }
}