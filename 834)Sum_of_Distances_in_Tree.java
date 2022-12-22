// First we count the distance of all other nodes from the root node '0'. 
// Then, we can find the distances of every other nodes w.r.t. other node using the distance of root node by the following formula:
// dis[i] = dis[root] - count[i] + (count.length - count[i])
// As we move, some nodes will get closer to the reference node, while some will get farther. 
// So, we just add the distance of the nodes that goes farther and subtract the distance of the nodes that gets closer.
// count[i] stores the number of nodes in a particular sub-tree.


class Solution {
    private int[] count;
    private int[] res;
    private List<HashSet<Integer>> tree;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        tree = new ArrayList<HashSet<Integer>>();
        res = new int[n];
        count = new int[n];
        for(int i=0; i<n; i++)
            tree.add(new HashSet<>());
        for(int[] a : edges) {
            tree.get(a[0]).add(a[1]);
            tree.get(a[1]).add(a[0]);
        }
        postOrder(0, -1);
        preOrder(0, -1);
        return res;
    }
    
    private void postOrder(int root, int pre) {
        for(int i : tree.get(root)) {
            if(i == pre)
                continue;
            postOrder(i, root);
            count[root] += count[i];
            res[root] += res[i] + count[i];
        }
        count[root]++;
    }
    
    private void preOrder(int root, int pre) {
        for(int i : tree.get(root)) {
            if(i == pre)
                continue;
            res[i] = res[root] - count[i] + count.length - count[i];
            preOrder(i, root);
        }
    }
}
