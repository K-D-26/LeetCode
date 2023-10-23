public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        
        ListNode slow = head, fast = head, dummy = head;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            // loop detected
            if(slow == fast) {
                while(slow != dummy) {
                    slow = slow.next;
                    dummy = dummy.next;
                }
                return dummy;
            }
        }
        
        return null;
    }
}