class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return head;
        ListNode odd = head, even = head.next, evenStart = even;
        while(even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            even = even.next;
            odd = odd.next;
        }
        odd.next = evenStart;
        return head;
    }
}
