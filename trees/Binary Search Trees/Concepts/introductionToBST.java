public class Solution {
    public static boolean isValidBST(int []order) {
        for (int i = 1; i < order.length; i++) {
            if (order[i] <= order[i-1]) {
                return false;
            }
        }

        return true;
    }
}