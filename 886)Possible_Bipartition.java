class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        if(n < 3)
            return true;
        
        int[] colour = new int[n+1];
        List<Integer>[] li = new List[n+1];
        for(int i=0; i<=n; i++)
            li[i] = new ArrayList<>();
        
        for(int[] arr : dislikes) {
            li[arr[0]].add(arr[1]);
            li[arr[1]].add(arr[0]);
        }
        
        for(int i=1; i<=n; i++) {
            if(colour[i] == 0) {
                LinkedList<Integer> q = new LinkedList<>();
                q.add(i);
                colour[i] = 1;
                while(q.size() != 0) {
                    int top = q.removeFirst();
                    for(int neighbour : li[top]) {
                        if(colour[neighbour] == colour[top])
                            return false;
                        if(colour[neighbour] == 0) {
                            colour[neighbour] = -colour[top];
                            q.add(neighbour);
                        }
                    }
                }
            }
        }        
        return true;
    }
}
