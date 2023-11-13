class Pair {
    Node node;
    int hd;
    public Pair(Node _node, int _hd) {
        node = _node;
        hd = _hd;
    }
}

class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        if(root == null) return ans;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair it = q.remove();
            int hd = it.hd;
            Node node = it.node;
            map.put(hd, node.data);
            
            if (node.left != null) {
                q.offer(new Pair(node.left, hd - 1));
            }
            
            if (node.right != null) {
                q.offer(new Pair(node.right, hd + 1));
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }
}