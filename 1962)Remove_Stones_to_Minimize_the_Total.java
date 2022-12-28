// Method 1 - O(n*k)
// Note: Here, TLE will occur for larger input.

class Solution {
    public int minStoneSum(int[] piles, int k) {
        for(int i=0; i<k; i++)
            findMax(piles);
        
        int n = 0;
        for(int i : piles)
            n += i;
        return n;
    }
    
    // function to find maximum value element in the array and reduce it to it's half floor value.
    private void findMax(int[] a) {
        int maxIdx = 0;
        for(int i=1; i<a.length; i++)
            if(a[i] > a[maxIdx])
                maxIdx = i;
        a[maxIdx] -= (a[maxIdx]/2);
    }
}

// --------------------------------------------------------------------------------------------------------------------------------------------------------------------

// Method 2 - O(n + klogn)

class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        int ans = 0;
        for(int i : piles) {
            pq.add(i);
            ans += i;
        }
        
        for(int i=0; i<k; i++) {
            int max = pq.poll();
            pq.add(max - max/2);
            ans -= max/2;
        }
        return ans;
    }
}
