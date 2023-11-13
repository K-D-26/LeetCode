class Pair {
    TreeNode node;
    int idx;
    public Pair(TreeNode n, int i) {
        this.node = n;
        this.idx = i;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        
        while (!q.isEmpty()) {
            int size = q.size();
            int mmin = q.peek().idx;        // to make the index start from 0
            int first = 0, last = 0;
            
            for (int i = 0; i < size; i++) {
                int curr_idx = q.peek().idx - mmin;
                TreeNode node = q.peek().node;
                q.poll();
                
                if (i == 0) first = curr_idx;
                if (i == size-1) last = curr_idx;
                
                if (node.left != null) {
                    q.offer(new Pair(node.left, 2*curr_idx + 1));       // left child
                }
                
                if (node.right != null) {
                    q.offer(new Pair(node.right, 2*curr_idx + 2));      // right child
                }
            }
            
            ans = Math.max(ans, last - first + 1);
        }
        
        return ans;
    }
}