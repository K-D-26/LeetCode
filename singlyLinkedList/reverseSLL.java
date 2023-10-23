class Solution {
    // Recursively
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = head;
        dummy = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return dummy;
    }

    
    // Iteratively
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = null;
        
        while(head != null) {
            ListNode temp = head.next;
            head.next = dummy;
            dummy = head;
            head = temp;
        }
        
        return dummy;
    }
}