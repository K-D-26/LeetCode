import java.util.* ;
import java.io.*;

public class Solution {

    public static int findCeil(TreeNode<Integer> root, int x) {
        TreeNode<Integer> node = root;
        int ans = -1;

        while (node != null) {
            if (node.data == x) {
                ans = node.data;
                return ans;
            }

            if (node.data < x) {
                node = node.right;
            }

            else {
                ans = node.data;
                node = node.left;
            }
        }

        return ans;
    }
}