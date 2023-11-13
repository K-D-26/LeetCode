import java.util.*;

public class Solution {
    public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start) {
        Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> map = new HashMap<>();
        BinaryTreeNode<Integer> target = bfsToMapParents(root, map, start);
        int maxi = findMaxDistance(map, target);

        return maxi;
    }

    private static int findMaxDistance(Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> map, BinaryTreeNode target) {
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.offer(target);
        Map<BinaryTreeNode<Integer>, Integer> vis = new HashMap<>();
        vis.put(target, 1);
        int maxi = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int flag = 0;

            for (int i = 0; i < size; i++) {
                BinaryTreeNode<Integer> node = q.poll();
                if (node.left != null && (vis.get(node.left) == null)) {
                    flag = 1;
                    vis.put(node.left, 1);
                    q.offer(node.left);
                }
                if (node.right != null && (vis.get(node.right) == null)) {
                    flag = 1;
                    vis.put(node.right, 1);
                    q.offer(node.right);
                }
                if (map.get(node) != null && (vis.get(map.get(node)) == null)) {
                    flag = 1;
                    vis.put(map.get(node), 1);
                    q.offer(map.get(node));
                }
            }

            if (flag == 1) maxi++;
        }

        return maxi;
    }

    private static BinaryTreeNode<Integer> bfsToMapParents(BinaryTreeNode<Integer> root, Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> map, int start) {
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        q.offer(root);
        BinaryTreeNode<Integer> ans = new BinaryTreeNode(-1);
        
        while (!q.isEmpty()) {
            BinaryTreeNode<Integer> node = q.poll();
            if (node.data == start) ans = node;
            if (node.left != null) {
                map.put(node.left, node);
                q.offer(node.left);
            }
            if (node.right != null) {
                map.put(node.right, node);
                q.offer(node.right);
            }
        }

        return ans;
    }
}