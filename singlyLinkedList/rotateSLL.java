class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        
        int l = 1;
        ListNode temp = head;
        
        // finding the length of the LL
        while(temp.next != null) {
            temp = temp.next;
            l++;
        }
        
        if(k % l == 0) return head;
        
        // make the LL circular
        temp.next = head;
        k = l - (k % l);
        while(k-- > 0) {
            temp = temp.next;
        }
        
        // make the node new head of LL and break the cycle
        head = temp.next;
        temp.next = null;
        
        return head;
    }
}