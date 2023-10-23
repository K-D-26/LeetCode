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
    
    Trie() {
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
            if(node.containsKey(1 - bit)) {
                maxNum = maxNum | (1 << i);
                node = node.get(1-bit);
            }
            else {
                node = node.get(bit);
            }
        }
        return maxNum;
    }
}


class Solution {
    public int findMaximumXOR(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> li = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            li.add(nums[i]);
        }
        
        return maxXOR(n, n, li, li);
    }
    
    public static int maxXOR(int n, int m, ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        Trie trie = new Trie();
        
        for(int i=0; i<n; i++) {
            Trie.insert(arr1.get(i));
        }
        
        int maxi = 0;
        for(int i=0; i<m; i++) {
            maxi = Math.max(maxi, trie.getMax(arr2.get(i)));
        }
        
        return maxi;
    }
}