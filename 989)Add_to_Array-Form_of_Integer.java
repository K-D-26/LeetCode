class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int b = num.length-1, c = 0, t = 0;
        List<Integer> li = new ArrayList<>();
        
        while(b >= 0 && k > 0) {
            t = num[b] + k%10 + c;
            li.add(t%10);
            k = k/10;
            c = t/10;
            b--;
        }
        
        while(b >= 0) {
            t = num[b] + c;
            c = t/10;
            li.add(t%10);
            b--;
        }
        
        while(k > 0) {
            t = k%10 + c;
            c = t/10;
            li.add(t%10);
            k = k/10;
        }
        
        while(c > 0) {
            li.add(c%10);
            c = c/10;
        }
        
        Collections.reverse(li);        
        return li;
    }
}
