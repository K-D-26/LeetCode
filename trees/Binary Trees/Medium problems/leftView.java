import java.util.*;
import java.io.*;

public class Solution {
    public static void leftView(BinaryTreeNode<Integer> root) {
        ArrayList<Integer> ans = new ArrayList<>();
        leftView(root, ans, 0);
        
        for (Integer i : ans) {
            System.out.print(i + " ");
        }
        
        return;
    }
    
    private static void leftView(BinaryTreeNode node, List<Integer> ans, int currSize) {
        if (node == null) return;
        
        if (currSize == ans.size()) ans.add((Integer)node.data);
        
        leftView(node.left, ans, currSize + 1);
        leftView(node.right, ans, currSize + 1);
    }
}