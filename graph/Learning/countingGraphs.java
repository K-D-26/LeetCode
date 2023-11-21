public class Solution {
    public static int countingGraphs(int n) {
        int cnt = n * (n-1) / 2;
        return (int)Math.pow(2, cnt);
    }
}