class Solution {
    public long distinctNames(String[] ideas) {
        long ans = 0;
        // Creating an array of sets to store the postfix (substring(1)) of each idea.
        Set<String>[] s = new Set[26];
        
        // Initializing the sets.
        for(int i=0; i<26; i++)
            s[i] = new HashSet<>();
        
        // Adding the postfix of each idea in the array of set at index of first-character.
        for(String st : ideas) {
            int head = st.charAt(0) - 'a';
            s[head].add(st.substring(1));            
        }
        
        // For all possible combinations, checking if the same postfix is present at 2 different indexes or not. If not present, increment the count.
        for(int i=0; i<26; i++) {
            for(int j=i+1; j<26; j++) {
                long cntI = 0, cntJ = 0;
                for(String sI : s[i])
                    if(!s[j].contains(sI))
                        cntI++;
                
                for(String sJ : s[j])
                    if(!s[i].contains(sJ))
                        cntJ++;
                
                // Result can be any combination of these strings.
                ans += cntI * cntJ;
            }            
        }
        
        // Result also includes permutation of strings. For example "time donuts" and "donuts time". So double the result and return it.
        return ans * 2;
    }
}
