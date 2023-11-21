class Pair {
    String st;
    int num;
    public Pair(String s, int n) {
        this.st = s;
        this.num = n;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        Set<String> set = new HashSet<>();
        for (String s : wordList) {
            set.add(s);
        }
        
        set.remove(beginWord);
        while (!q.isEmpty()) {
            String word = q.peek().st;
            int steps = q.peek().num;
            q.poll();
            
            if (word.equals(endWord)) {
                return steps;
            }
            
            for (int i = 0; i < word.length(); i++) {
                for (char c='a'; c<='z'; c++) {
                    char[] replaced = word.toCharArray();
                    replaced[i] = c;
                    String replacedWord = new String(replaced);
                    
                    if (set.contains(replacedWord)) {
                        set.remove(replacedWord);
                        q.offer(new Pair(replacedWord, steps + 1));
                    }
                }
            }
        }
        
        return 0;
    }
}