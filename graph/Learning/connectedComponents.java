import java.util.* ;
import java.io.*; 

public class Solution {
    public static int findNumOfProvinces(int[][] roads, int n) {
        ArrayList<ArrayList<Integer>> adjls = new ArrayList<ArrayList<Integer>>();
        
        for (int i = 0; i < n; i++) adjls.add(new ArrayList<Integer>());
            
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (roads[i][j] != 0 && i != j) {
                    adjls.get(i).add(j);
                    adjls.get(j).add(i);
                }
            }
        }
        
        int[] vis = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, adjls);
                ans++;
            }
        }
        
        return ans;
    }
    
    private static void dfs(int s, int[] vis, ArrayList<ArrayList<Integer>> adjls) {
        vis[s] = 1;
        for (Integer i : adjls.get(s)) {
            if (vis[i] == 0)
                dfs(i, vis, adjls);
        }
    }
}