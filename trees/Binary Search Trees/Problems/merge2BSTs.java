import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> mergeBST(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        inorder(root1, l1);
        List<Integer> l2 = new ArrayList<>();
        inorder(root2, l2);

        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) <= l2.get(j)) {
                ans.add(l1.get(i));
                i++;
            }
            else {
                ans.add(l2.get(j++));
            }
        }

        while (i < l1.size()) {
            ans.add(l1.get(i++));
        }
        while (j < l2.size()) {
            ans.add(l2.get(j++));
        }

        return ans;
    }

    private static void inorder(TreeNode node, List<Integer> li) {
        if (node == null) return;
        
        inorder(node.left, li);
        li.add(node.data);
        inorder(node.right, li);
    }
}