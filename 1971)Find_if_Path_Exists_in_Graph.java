// dfs approach:

class Solution {
    private boolean seen;
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashSet<Integer>[] graph = new HashSet[n];
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++) 
            graph[i] = new HashSet<>();
        
        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        // if source and destination are directly connected
        if(graph[source].contains(destination))
            return true;
        
        seen = false;
        dfs(graph, visited, source, destination);
        return seen;
    }
    
    private void dfs(HashSet<Integer>[] graph, boolean[] visited, int src, int des) {
        if(!visited[src] && !seen) {
            if(src == des) {
                seen = true;
                return;
            }
            
            visited[src] = true;
            for(Integer neighbour : graph[src])
                dfs(graph, visited, neighbour, des);
        }
    }
}
