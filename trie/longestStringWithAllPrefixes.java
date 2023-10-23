import java.util.*;
import java.io.*;

class Node {
    Node[] links = new Node[26];
    boolean flag = false;

    public Node() {
    }

    boolean containsKey(char c) {
        return links[c - 'a'] != null;
    }

    Node get(char c) {
        return links[c - 'a'];
    }

    void put(char c, Node node) {
        links[c - 'a'] = node;
    }

    boolean isEnd() {
        return flag;
    }

    void setEnd() {
        flag = true;
    }
}

class Trie {
    private static Node root;

    public Trie() {
        root = new Node();
    }

    public static void insert(String s) {
        Node node = root;
        for (int i = 0; i < s.length(); i++) {
            if (!node.containsKey(s.charAt(i))) {
                node.put(s.charAt(i), new Node());
            }
            node = node.get(s.charAt(i));
        }
        node.setEnd();
    }

    public static boolean checkPrefixExists(String s) {
        Node node = root;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (node.containsKey(s.charAt(i))) {
                node = node.get(s.charAt(i));
                flag = flag & node.isEnd();
            } else {
                return false;
            }
        }
        return flag;
    }
}

class Solution {
    public static String completeString(int n, String[] a) {
        Trie obj = new Trie();
        for (int i = 0; i < n; i++) {
            obj.insert(a[i]);
        }

        String longest = "";
        for (int i = 0; i < n; i++) {
            if (obj.checkPrefixExists(a[i])) {
                if (a[i].length() > longest.length()) {
                    longest = a[i];
                } else if (a[i].length() == longest.length() && a[i].compareTo(longest) < 0) {
                    longest = a[i];
                }
            }
        }

        if (longest == "")
            return "None";
        return longest;
    }
}