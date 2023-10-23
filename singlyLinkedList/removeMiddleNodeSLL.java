class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        
        ListNode slow = head, fast = head;
        ListNode prev = new ListNode(0);
        prev.next = head;
        
        while(fast.next != null && fast.next.next != null) {
            prev = prev.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast.next == null) {
            prev.next = slow.next;
        }
        else {
            slow.next = slow.next.next;
        }
        
        return head;
    }
}