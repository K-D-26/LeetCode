class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode curr = dummy, prev = dummy, next = dummy;
        int l = 0;
        
        while(curr.next != null) {
            curr = curr.next;
            l++;
        }
        
        while(l >= k) {
            curr = prev.next;
            next = curr.next;
            for(int i=1; i<k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            l -= k;
        }
        
        return dummy.next;
    }
}