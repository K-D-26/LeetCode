class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode dummy = new ListNode();
        
        ListNode prev = dummy;
        ListNode curr = head;
        
        while(curr != null && curr.next != null) {
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev.next.next = curr;
            
            prev = curr;
            curr = curr.next;
        }
        
        return dummy.next;
    }
}
