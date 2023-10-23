public class Solution {
    public static Node deleteAllOccurrences(Node head, int k) {
        if(head == null) {
            return head;
        }

        Node temp = head;
        while(temp != null) {
            if(temp.data == k) {
                if(temp == head) {
                    head = head.next;
                }
                else {
                    Node prev = temp.prev;
                    prev.next = temp.next;
                }
            }
            temp = temp.next;
        }

        return head;
    }
}