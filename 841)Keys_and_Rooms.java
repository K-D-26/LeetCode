// Method 1 - Using HashSet:

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> seen = new HashSet<>();
        Stack<Integer> checkRoom = new Stack<>();
        
        seen.add(0);
        checkRoom.add(0);
        
        while(!checkRoom.empty()) {
            int i = checkRoom.pop();
            for(int j : rooms.get(i))
                if(!seen.contains(j)) {
                    seen.add(j);
                    checkRoom.add(j);
                    if(rooms.size() == seen.size())
                        return true;
                }
        }
        
        return rooms.size() == seen.size();
    }
}


// Method 2 - Using Array:

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        int count = 0;
        count = checkRoom(rooms, 0, visited, count);
        return count == rooms.size();
    }
    
    private int checkRoom(List<List<Integer>> rooms, int currRoom, boolean[] visited, int count) {
        if(visited[currRoom])
            return count;
        visited[currRoom] = true;
        ++count;
        for(int i : rooms.get(currRoom))
            count = checkRoom(rooms, i, visited, count);
        return count;
    }
}
