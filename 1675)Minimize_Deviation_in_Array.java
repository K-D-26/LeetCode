// Method 1: Using Priority Queue
// First we store the elements of the array in a priority queue in decreasing order. If the element is odd, double it and store in the 'pq'. Also keep a note of minimum element in the array.
// Then we find the difference and to make the difference minimum, reduce the maximum element by half until it remains even.
// At last, return the minimum of 'diff' and the difference of maximum element of 'pq' and 'min'

class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        int min = Integer.MAX_VALUE;
        
        for(int i : nums) {
            if(i%2 == 1)
                i *= 2;
            min = Math.min(min, i);
            pq.add(i);
        }
        
        int diff = Integer.MAX_VALUE;
        while(pq.peek()%2 == 0) {
            int max = pq.remove();
            diff = Math.min(diff, max-min);
            min = Math.min(min, max/2);
            pq.add(max/2);
        }
        
        return Math.min(diff, pq.peek()-min);
    }
}

// Time complexity: O(n(log(n))(log(m)))        [m --> highest value in the array]
// Space complexity: O(n)




// Method 2: Using Tree Set
// First we store the elements of the array in a Tree Set. If the element is odd, double it and store in the 'pq'.
// Then we find the difference between maximum and minimum element. Then to make the difference minimum, we reduce the maximum element by half if it is even else return the difference.

class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> ts = new TreeSet<>();        
        
        for(int i : nums) {
            if(i%2 == 1)
                i *= 2;            
            ts.add(i);
        }
        
        int diff = Integer.MAX_VALUE;
        while(true) {
            int max = ts.last();
            int min = ts.first();
            diff = Math.min(diff, max-min);
            if(max%2 == 0) {
                ts.remove(max);
                ts.add(max/2);
            }
            else
                break;
        }
        
        return diff;
    }
}

// Time complexity: O(n(log(n))(log(m)))        [m --> highest value in the array]
// Space complexity: O(n)
