import java.util.* ;
import java.io.*; 

public class Solution {
    public static int[][] printAdjacency(int n, int m, int[][] edges) {
        int[][] res = new int[n][];
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        for (int i = 0; i < adjList.size(); i++) {
            int size = adjList.get(i).size();
            int[] temp = new int[size + 1];
            temp[0] = i;
            for (int j = 0; j < size; j++) {
                temp[j+1] = adjList.get(i).get(j);
            }
            res[i] = temp;
        }

        return res;
    }
}