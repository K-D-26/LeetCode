class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        
        TreeNode root = helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
        return root;
    }
    
    private TreeNode helper(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if(preStart > preEnd || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(pre[preStart]);
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;
        
        root.left = helper(pre, preStart + 1, preStart + numsLeft, in, inStart, inRoot - 1, inMap);
        root.right = helper(pre, preStart + numsLeft + 1, preEnd, in, inRoot + 1, inEnd, inMap);
        return root;
    }
}


// -----------------------------------------------------------------------------------------------------------------------------------------------------
// If the tree contains duplicate values (Question on GFG)

class Solution {
    public static Node buildTree(int inorder[], int preorder[], int n) {
        Map<Integer, PriorityQueue<Integer>> inMap = new HashMap<>();
        for(int i=0; i<n; i++) {
            inMap.putIfAbsent(inorder[i], new PriorityQueue<>());
            inMap.get(inorder[i]).offer(i);
        }
        return helper(inorder, 0, n-1, preorder, 0, n-1, inMap);
    }
    
    private static Node helper(int[] inorder, int inStart, int inEnd, int[] preorder, int preStart, int preEnd, Map <Integer, PriorityQueue<Integer>> inMap) {
        if(preStart > preEnd || inStart > inEnd) return null;

        Node root = new Node(preorder[preStart]);

        int inRoot = inMap.get(root.data).poll();
        int numLeft = inRoot - inStart;

        root.left = helper(inorder, inStart, inRoot - 1, preorder, preStart + 1, preStart + numLeft, inMap);
        root.right = helper(inorder, inRoot + 1, inEnd, preorder, preStart + numLeft + 1, preEnd, inMap);

        return root;
    }
}
