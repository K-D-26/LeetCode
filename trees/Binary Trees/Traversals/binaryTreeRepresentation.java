import java.util.Queue;

public class Solution {
    public static Node createTree(int []arr){
        return solve(arr, 0, arr.length);
    }

    private static Node solve(int[] a, int i, int n) {
        Node root;
        if (i < n) {
            root = new Node(a[i]);
            root.left = solve(a, 2*i + 1, n);
            root.right = solve(a, 2*i + 2, n);
            return root;
        }
        else {
            return null;
        }
    }
}