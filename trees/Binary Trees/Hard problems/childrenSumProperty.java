
public class Solution {
    public static boolean isParentSum(Node root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;

        int left = root.left != null ? root.left.data : 0;
        int right = root.right != null ? root.right.data : 0;

        if (root.data != left + right) return false;
        return isParentSum(root.left) && isParentSum(root.right);
    }
}