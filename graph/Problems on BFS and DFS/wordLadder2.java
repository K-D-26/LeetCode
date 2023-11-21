// Method 1 (BFS):

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        int len = wordList.size();
        for (int i = 0; i < len; i++) {
            set.add(wordList.get(i));
        }
        
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> ls = new ArrayList<>();
        ls.add(beginWord);
        q.offer(ls);
        
        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);
        int level = 0;
        List<List<String>> ans = new ArrayList<>();
        int cnt = 0;
        
        while (!q.isEmpty()) {
            cnt++;
            ArrayList<String> vec = q.peek();
            q.remove();
            
            if (vec.size() > level) {
                level++;
                for (String st : usedOnLevel) {
                    set.remove(st);
                }
            }
            
            String word = vec.get(vec.size() - 1);
            
            if (word.equals(endWord)) {
                if (ans.size() == 0) {
                    ans.add(vec);
                }
                else if (ans.get(0).size() == vec.size()) {
                    ans.add(vec);
                }
            }
            
            for (int i = 0; i < word.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = c;
                    String replacedWord = new String(replacedCharArray);
                    if (set.contains(replacedWord)) {
                        vec.add(replacedWord);
                        ArrayList<String> temp = new ArrayList<>(vec);
                        q.add(temp);
                        usedOnLevel.add(replacedWord);
                        vec.remove(vec.size() - 1);
                    }
                }
            }
        }
        
        return ans;
    }
}


// Method 2 (DFS + Backtracking) (Optimized):

class Solution {
    String b;                                   // beginWord
    HashMap<String, Integer> map;
    List<List<String>> ans;
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        int len = wordList.size();
        for (int i = 0; i < len; i++) {
            set.add(wordList.get(i));
        }
        
        Queue<String> q = new LinkedList<>();
        b = beginWord;
        q.offer(beginWord);
        map = new HashMap<>();
        map.put(beginWord, 1);
        int size = beginWord.length();
        set.remove(beginWord);
        
        while (!q.isEmpty()) {
            String word = q.peek();
            int steps = map.get(word);
            q.remove();
            
            if (word.equals(endWord)) break;
            
            for (int i = 0; i < size; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = c;
                    String replacedWord = new String(replacedCharArray);
                    if (set.contains(replacedWord)) {
                        q.offer(replacedWord);
                        set.remove(replacedWord);
                        map.put(replacedWord, steps + 1);
                    }
                }
            }
        }
        
        ans = new ArrayList<>();
        if (map.containsKey(endWord)) {
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord, seq);
        }
        
        return ans;
    }
    
    private void dfs(String word, List<String> seq) {
        if (word.equals(b)) {
            List<String> dup = new ArrayList<>(seq);
            Collections.reverse(dup);
            ans.add(dup);
            return;
        }
        
        int steps = map.get(word);
        int sz = word.length();
        for (int i = 0; i < sz; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                char[] replacedCharArray = word.toCharArray();
                replacedCharArray[i] = c;
                String replacedWord = new String(replacedCharArray);
                if (map.containsKey(replacedWord) && map.get(replacedWord) + 1 == steps) {
                    seq.add(replacedWord);
                    dfs(replacedWord, seq);
                    seq.remove(seq.size() - 1);
                }
            }
        }
    }
}