class Tuple {
    TreeNode node;
    int vertical;
    int level;
    public Tuple(TreeNode n, int v, int l) {
        this.node = n;
        this.vertical = v;
        this.level = l;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple t = q.poll();
            TreeNode node = t.node;
            int x = t.vertical;
            int y = t.level;

            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.val);
            
            if (node.left != null) {
                q.offer(new Tuple(node.left, x-1, y+1));
            }
            
            if (node.right != null) {
                q.offer(new Tuple(node.right, x+1, y+1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> t : map.values()) {
            ans.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : t.values()) {
                while (!nodes.isEmpty()) {
                    ans.get(ans.size()-1).add(nodes.poll());
                }
            }
        }

        return ans;
    }
}