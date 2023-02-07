// Approach:
// First we create a map and a queue.
// We will add the elements of the 'fruits' array one-by-one in the queue.
// We will also store the frequency of a particular element in tha map and keep a note that the length of the map should not exceed 2. If it does, we will remove one-by-one element from queue and also reduce it's frequency in the map by 1. When an element's frequency reaches 0, we remove it completely from the map. Then add the new element that we encountered.
// This way we can keep a count that not more than 2 types of fruits are kept in the baskets.
// Perform these steps for the entire array.
// Keep a count of maximum fruits at each new tree encounter. At one step, the number of fruits will be equal to the size of the queue.
// At last return the maximum size of the queue you encounter during the process.


class Solution {
    public int totalFruit(int[] fruits) {
        if(fruits.length < 2)
            return fruits.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int ans = 0;
        
        q.add(fruits[0]);
        map.put(fruits[0], 1);
        
        for(int i=1; i<fruits.length; i++) {
            if(map.size() < 2 || map.containsKey(fruits[i])) {
                map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
                q.add(fruits[i]);
            }
            else {
                while(map.size() > 1) {
                    int n = q.remove();
                    map.put(n, map.get(n) - 1);
                    if(map.get(n) == 0) {
                        map.remove(n);
                        break;
                    }
                }
                map.put(fruits[i], 1);
                q.add(fruits[i]);
            }
            ans = Math.max(ans, q.size());
        }
        
        return ans;
    }
}
