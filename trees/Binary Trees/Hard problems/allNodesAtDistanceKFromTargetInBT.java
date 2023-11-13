class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        markParents(root, parent_track, root);          // marking parents of each node
        
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target, true);
        int curr_level = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            if (curr_level == k) break;
            
            curr_level++;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null && visited.get(curr.left) == null) {
                    q.offer(curr.left);
                    visited.put(curr.left, true);
                }
                if (curr.right != null && visited.get(curr.right) == null) {
                    q.offer(curr.right);
                    visited.put(curr.right, true);
                }
                if (parent_track.get(curr) != null && visited.get(parent_track.get(curr)) == null) {
                    q.offer(parent_track.get(curr));
                    visited.put(parent_track.get(curr), true);
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            ans.add(node.val);
        }
        
        return ans;
    }
    
    private static void markParents(TreeNode node, Map<TreeNode, TreeNode> map, TreeNode target) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                map.put(curr.left, curr);
                q.offer(curr.left);
            }
            if (curr.right != null) {
                map.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }
}