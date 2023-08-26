class Solution {
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode target = bfsToMapParents(root, map, start);
        int maxi = findMaxDistance(map, target);
        return maxi;
    }

    // find the time taken to infect all the nodes in the tree
    private static int findMaxDistance(Map<TreeNode, TreeNode> map, TreeNode target) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        Map<TreeNode, Integer> vis = new HashMap<>();
        vis.put(target, 1);
        int maxi = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            int flag = 0;

            // in one unit time, it will infect all its adjacent nodes.
            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                if(node.left != null && (vis.get(node.left) == null)) {
                    flag = 1;
                    vis.put(node.left, 1);
                    q.offer(node.left);
                }
                if(node.right != null && (vis.get(node.right) == null)) {
                    flag = 1;
                    vis.put(node.right, 1);
                    q.offer(node.right);
                }
                if(map.get(node) != null && (vis.get(map.get(node)) == null)) {
                    flag = 1;
                    vis.put(map.get(node), 1);
                    q.offer(map.get(node));
                }
            }
            if(flag == 1) maxi++;
        }

        return maxi;
    }

    // mark the parents of each node
    private static TreeNode bfsToMapParents(TreeNode root, Map<TreeNode, TreeNode> map, int start) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode ans = new TreeNode(-1);
        
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node.val == start) ans = node;
            if(node.left != null) {
                map.put(node.left, node);
                q.offer(node.left);
            }
            if(node.right != null) {
                map.put(node.right, node);
                q.offer(node.right);
            }
        }

        return ans;
    }
}
