import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        List<Integer>list=new ArrayList<>();
        TreeNode temp = root;
        int pre = -1;
        int suc = -1;
        
        while (temp != null) {
            if (temp.data == key) {
                break;
            }

            else if (temp.data > key) {
                suc = temp.data;
                temp = temp.left;
            }

            else {
                pre = temp.data;
                temp = temp.right;
            }
        }

        if (temp!=null && temp.left!=null) {
            TreeNode leftsubtree = temp.left;
            while (leftsubtree.right != null) {
                leftsubtree = leftsubtree.right;
            }
            pre = leftsubtree.data;
        }

        if (temp != null && temp.right != null) {
            TreeNode rightsubtree = temp.right;
            while (rightsubtree.left != null) {
                rightsubtree = rightsubtree.left;
            }
            suc = rightsubtree.data;
        }

        list.add(pre);
        list.add(suc);
        
        return list;
    }
}