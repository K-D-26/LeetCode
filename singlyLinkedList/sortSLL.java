// approach similar to merge sort

class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        // Step 1: Break the linked list in 2 halves
        ListNode prev = null, slow = head, fast = head;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        
        // Step 2: sort the two halves
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        // Step 3: merge the two halves
        return merge(l1, l2);
    }
    
    private ListNode merge(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        
        ListNode head = null, tail = null;
        if(list1.val < list2.val) {
            head = tail = list1;
            list1 = list1.next;
        }
        else {
            head = tail = list2;
            list2 = list2.next;
        }
        
        while(list1 != null && list2 != null) {
            if(list1.val > list2.val) {
                tail.next = list2;
                list2 = list2.next;
            }
            else {
                tail.next = list1;
                list1 = list1.next;
            }
            tail = tail.next;
        }
        
        if(list1 == null) {
            tail.next = list2;
        }
        else {
            tail.next = list1;
        }
        
        return head;
    }
}