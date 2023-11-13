class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        LinkedList<TreeNode> ll = new LinkedList<>();
        ll.add(root);
        boolean flag = false;

        while (ll.size() > 0) {
            int size = ll.size();
            ArrayList<Integer> al = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                root = ll.poll();
                if (root.left != null) ll.add(root.left);
                if (root.right != null) ll.add(root.right);
                al.add(root.val);
            }
            
            if (flag == false) {
                ans.add(al);
                flag = true;
            }
            else {
                Collections.reverse(al);
                ans.add(al);
                flag = false;
            }
        }
        
        return ans;
    }
}