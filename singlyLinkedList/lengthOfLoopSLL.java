public class Solution {
    public static int lengthOfLoop(Node head) {
        if(head == null || head.next == null) {
            return 0;
        }

        Node slow = head, fast = head;
        int length = 0;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // loop detected
            if(slow == fast) {
                while(fast.next != slow) {
                    length++;
                    fast = fast.next;
                }
                return length + 1;
            }
        }

        return length;
    }
}