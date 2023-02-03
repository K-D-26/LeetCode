// The idea is to store each row of the output in a string-buffer and then combine all the buffers into a single buffer and return it.

class Solution {
    public String convert(String s, int numRows) {
        // base case
        if(numRows == 1 || s.length() == 1 || (s.length() <= numRows))
            return s;
        
        // for storing each rows of the output
        StringBuilder[] sbs = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++)
            sbs[i] = new StringBuilder();
        
        // defining variables
        char[] ch = s.toCharArray();
        int n = ch.length;
        int idx = 0;
        
        // travelling in zig-zag manner and storing the characters in the respective buffer
        while(idx < n) {
            // Going down
            for(int j=0; j<numRows && idx<n; j++)
                sbs[j].append(ch[idx++]);
            
            // Going diagonally up
            for(int j=numRows-2; j>0 && idx<n; j--)
                sbs[j].append(ch[idx++]);
        }
        
        // Combining all the buffers into one buffer        
        for(int i=1; i<numRows; i++)
            sbs[0].append(sbs[i].toString());
        
        return sbs[0].toString();
    }
}
