import java.util.*;
import java.io.*;

public class Solution {
	public static ArrayList<Integer> traverseBoundary(TreeNode node) {
		ArrayList<Integer> ans = new ArrayList<>();
        if (isLeaf(node) == false) ans.add(node.data);

        addLeftBoundary(node, ans);
        addLeaves(node, ans);
        addRightBoundary(node, ans);
        
        return ans;    
	}

    static void addLeftBoundary(TreeNode root, ArrayList <Integer> res) {
        TreeNode curr = root.left;

        while (curr != null) {
            if (isLeaf(curr) == false) res.add(curr.data);
            if (curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }
    static void addRightBoundary(TreeNode root, ArrayList <Integer> res) {
        TreeNode curr = root.right;
        ArrayList<Integer> temp = new ArrayList<>();

        while (curr != null) {
            if (isLeaf(curr) == false) temp.add(curr.data);
            if (curr.right != null) curr = curr.right;
            else curr = curr.left;
        }

        for (int i = temp.size() - 1; i >= 0; i--) {
            res.add(temp.get(i));
        }
    }

    static void addLeaves(TreeNode root, ArrayList <Integer> res) {
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }
        if (root.left != null) addLeaves(root.left, res);
        if (root.right != null) addLeaves(root.right, res);
    }

	static Boolean isLeaf(TreeNode root) {
        return (root.left == null) && (root.right == null);
    }
}