public class Solution {
    public static Node uniqueSortedList(Node head) {
        if(head == null) {
            return null;
        }

        Node curr = head;

        while(curr != null) {
            if(curr.next != null && curr.data == curr.next.data) {
                Node nextNext = curr.next.next;
                // curr.next.next = null;
                curr.next = nextNext;
            } 
            else {
                curr = curr.next;
            }
        }

        return head;
    }
}