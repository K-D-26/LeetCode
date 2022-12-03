class Solution {
    public String frequencySort(String s) {
        // Using Bucket Sort:
        // Get count of each alphabet
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
                
        // Create an array of List of Character and add the alphabets in the array according to the frequency of the alphabet        
        List<Character>[] bucket = new ArrayList[s.length()+1];
        for(char key : map.keySet()) {
            int freq = map.get(key);
            if(bucket[freq] == null)
                bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }
        // Note: we will just add the alphabet one time in the array and later we will append the character to the StringBuilder number of times based on its position.
        
        // Append the alphabets according to the position into the StringBuilder.
        StringBuilder sb = new StringBuilder();
        for(int pos=bucket.length-1; pos>0; pos--)
            if(bucket[pos] != null)
                for(char c : bucket[pos])
                    for(int i=0; i<pos; i++)
                        sb.append(c);
        
        // convert StringBuilder to String and return.
        return sb.toString();
    }
}
