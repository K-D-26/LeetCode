public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        
        ListNode d1 = headA, d2 = headB;
        while(d1 != d2) {
            d1 = d1 == null ? headB : d1.next;
            d2 = d2 == null ? headA : d2.next;
        }
        
        return d1;
    }
}