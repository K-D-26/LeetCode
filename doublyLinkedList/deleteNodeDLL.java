public class Solution {
    public static Node deleteLastNode(Node head) {
        if(head == null || head.next == null) return null;

        Node curr = head;

        while(curr.next.next != null) {
            curr = curr.next;
        }

        Node temp = curr.next;
        curr.next = null;
        // temp.prev = null;

        return head;
    }
}