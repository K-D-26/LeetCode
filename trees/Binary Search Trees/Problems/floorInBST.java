import java.util.*;

public class solution {
	public static int Floor(BinaryTreeNode<Integer> node, int x) {
		int ans = -1;

		while (node != null) {
			if (node.data == x) {
				ans = node.data;
				return ans;
			}

			else if (node.data > x) {
				node = node.left;
			}

			else {
				ans = node.data;
				node = node.right;
			}
		}

		return ans;
	}
}