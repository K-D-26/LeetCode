import java.util.*;
import java.io.*; 

class Pair {
    int first, second;
    
    public Pair(int f, int s) {
        this.first = f;
        this.second = s;
    }
}

public class Solution {
    public static boolean findPair(Node<Integer> head, int k) {
        List<Pair<Integer, Integer>> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Node temp = head;

        while(temp != null) {
            int complement = k - temp.data;

            // Check if the complement value is in the set of seen values
            if(set.contains(complement)) {
                ans.add(new Pair<>(temp.data, complement));
            }

            // Add the current data value to the set of seen values
            set.add(temp.data);
            temp = temp.next;
        }
        return ans;
    }
}