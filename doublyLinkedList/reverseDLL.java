public class Solution {
    public static Node reverseDLL(Node head) {
        Node curr = head;
        Node next, prev = null;

        while(curr != null) {
            next = curr.next;
            curr.next = curr.prev;
            curr.prev = next;
            prev = curr;
            curr = curr.prev;
        }

        head = prev;
        return head;
    }
}