class Pair {
    int hd;
    Node node;
    public Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

class Solution {
	static ArrayList<Integer> topView(Node root) {
		ArrayList<Integer> ans = new ArrayList<>();
		
		if(root == null) return ans;
		
		TreeMap<Integer, Integer> map = new TreeMap<>();
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(root, 0));

		while(!q.isEmpty()) {
			Pair it = q.remove();
			int hd = it.hd;
			Node node = it.node;
			
			if (map.get(hd) == null) map.put(hd, node.data);
			if (node.left != null) q.add(new Pair(node.left, hd - 1));
			if (node.right != null) q.add(new Pair(node.right, hd + 1));
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			ans.add(entry.getValue());
		}

		return ans;
	}
}