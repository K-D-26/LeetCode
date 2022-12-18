// Method 1: Using Stack:

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<temperatures.length; i++) {
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                int idx = s.pop();
                ans[idx] = i - idx;
            }
            s.push(i);
        }
        return ans;
    }
}


// Method 2 - Using Deque:

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {        
        int[] ans = new int[temperatures.length];
        Deque<Integer> s = new ArrayDeque<>();
        for(int i=0; i<temperatures.length; i++) {
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                int idx = s.pop();
                ans[idx] = i - idx;
            }
            s.push(i);
        }
        return ans;
    }
}
