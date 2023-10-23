import java.util.*;
import java.io.*; 

class Node {
    Node[] links = new Node[26];
    int cntEndWith = 0;
    int cntPrefix = 0;
    
    public Node() {}
    
    boolean containsKey(char c) {
        return links[c-'a'] != null;
    }

    Node get(char c) {
        return links[c-'a'];
    }

    void put(char c, Node node) {
        links[c-'a'] = node;
    }

    void increaseEnd() {
        cntEndWith++;
    }

    void decreaseEnd() {
        cntEndWith--;
    }

    void increasePrefix() {
        cntPrefix++;
    }

    void decreasePrefix() {
        cntPrefix--;
    }

    int getEnd() {
        return cntEndWith;
    }

    int getPrefix() {
        return cntPrefix;
    }
}

public class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for(int i=0; i<word.length(); i++) {
            if(!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
            node.increasePrefix();
        }
        node.increaseEnd();
    }

    public int countWordsEqualTo(String word) {
        Node node = root;
        for(int i=0; i<word.length(); i++) {
            if(!node.containsKey(word.charAt(i))) {
                return 0;
            }
            node = node.get(word.charAt(i));
        }
        return node.getEnd();
    }

    public int countWordsStartingWith(String word) {
        Node node = root;
        for(int i=0; i<word.length(); i++) {
            if(!node.containsKey(word.charAt(i))) {
                return 0;
            }
            node = node.get(word.charAt(i));
        }
        return node.getPrefix();
    }

    public void erase(String word) {
        Node node = root;
        for(int i=0; i<word.length(); i++) {
            node = node.get(word.charAt(i));
            node.decreasePrefix();
        }
        node.decreaseEnd();
    }

}
