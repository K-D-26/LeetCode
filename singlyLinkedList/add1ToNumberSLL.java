import java.util.*;
import java.io.*; 

public class Solution {
	public static Node addNode(Node head) {
		int n = 0;
        while(head != null) {
            n = n*10 + head.data;
            head = head.next;
        }
		
        n++;
        int t = n;
        Node res = new Node(-1);
        Node temp = res;

        while(t > 0) {
            Node node = new Node(t%10);
            t = t/10;
            temp.next = node;
            temp = temp.next;
        }

        return res.next;
	}
}