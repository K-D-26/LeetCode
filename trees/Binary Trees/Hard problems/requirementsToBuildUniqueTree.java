public class Solution {
    public static boolean uniqueBinaryTree(int a, int b) {
        if (a == b) return false;
        else if (a == 2 || b == 2) return true;         // inorder == 2

        return false;
    }
}