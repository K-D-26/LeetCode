class Node {
    Node[] links = new Node[2];
    
    public Node() {}
    
    boolean containsKey(int i) {
        return links[i] != null;
    }
    
    Node get(int i) {
        return links[i];
    }
    
    void put(int i, Node node) {
        links[i] = node;
    }
}

class Trie {
    private static Node root;
    
    public Trie() {
        root = new Node();
    }
    
    public static void insert(int num) {
        Node node = root;
        for(int i=31; i>=0; i--) {
            int bit = (num >> i) & 1;
            if(!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }
    
    public int getMax(int num) {
        Node node = root;
        int maxNum = 0;
        for(int i=31; i>=0; i--) {
            int bit = (num >> i) & 1;
            if(node.containsKey(1-bit)) {
                maxNum = maxNum | (1<<i);
                node = node.get(1 - bit);
            }
            else {
                node = node.get(bit);
            }
        }
        
        return maxNum;
    }
}


class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        ArrayList<Integer> li = maxXorQueries(nums, queries);
        int[] ans = new int[li.size()];
        
        for(int i=0; i<li.size(); i++) {
            ans[i] = li.get(i);
        }
        
        return ans;
    }
    
    public static ArrayList<Integer> maxXorQueries(int[] arr, int[][] queries) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> offlineQueries = new ArrayList<ArrayList<Integer>>();
        int m = queries.length;
        
        for(int i=0; i<m; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(queries[i][1]);
            temp.add(queries[i][0]);
            temp.add(i);
            offlineQueries.add(temp);
        }
        
        Collections.sort(offlineQueries, new Comparator<ArrayList<Integer>> () {
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                return a.get(0).compareTo(b.get(0));
            }
        });
        
        int ind = 0;
        int n = arr.length;
        Trie trie = new Trie();
        ArrayList<Integer> ans = new ArrayList<>(m);
        
        for(int i=0; i<m; i++) {
            ans.add(-1);
        }
        
        for(int i=0; i<m; i++) {
            while(ind < n && arr[ind] <= offlineQueries.get(i).get(0)) {
                trie.insert(arr[ind]);
                ind++;
            }
            int queryInd = offlineQueries.get(i).get(2);
            if(ind != 0) {
                ans.set(queryInd, trie.getMax(offlineQueries.get(i).get(1)));
            }
            else {
                ans.set(queryInd, -1);
            }
        }
        
        return ans;
    }
}