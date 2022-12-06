// Method 1 (Counting using HashMap):
class Solution {
    public int percentageLetter(String s, char letter) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);        
        int n = 0, m = s.length();
        if(map.get(letter) != null)
            n = map.get(letter);
        return (int)n*100/m;
    }
}


// Method 2 (Counting using Character Array):
class Solution {
    public int percentageLetter(String s, char letter) {
        int n = 0;
        for(char c : s.toCharArray())
            if(c == letter)
                n++;
        if(n == 0)
            return 0;
        int m = s.length();
        return n*100/m;
    }
}
