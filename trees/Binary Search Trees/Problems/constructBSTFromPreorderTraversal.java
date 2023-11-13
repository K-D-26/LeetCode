class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreOrder(preorder, Integer.MAX_VALUE, new int[]{0});
    }
    
    private static TreeNode bstFromPreOrder(int[] arr, int ubound, int[] a) {
        if (a[0] == arr.length || arr[a[0]] > ubound) return null;
        
        TreeNode root = new TreeNode(arr[a[0]++]);
        root.left = bstFromPreOrder(arr, root.val, a);
        root.right = bstFromPreOrder(arr, ubound, a);
        
        return root;
    }
}