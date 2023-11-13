import java.util.* ;
import java.io.*; 

public class Solution {
	public static ArrayList<String> allRootToLeaf(BinaryTreeNode root) {
		ArrayList<String> answer = new ArrayList<String>();
        if (root != null) {
            searchBT(root, "", answer);
        }
        
        return answer;
    }
    
    private static void searchBT(BinaryTreeNode root, String path, ArrayList<String> answer) {
        if (root.left == null && root.right == null) {
            answer.add(path + root.data);
        }

        if (root.left != null) {
            searchBT(root.left, path + root.data + " ", answer);
        }

        if (root.right != null) {
            searchBT(root.right, path + root.data + " ", answer);
        }
	}
}