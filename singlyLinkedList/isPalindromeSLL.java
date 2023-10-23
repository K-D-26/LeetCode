class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // finding middle of linked list
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reversing the other half of the linked list
        slow.next = reverseLL(slow.next);

        slow = slow.next;
        while (slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }

        return true;
    }

    private ListNode reverseLL(ListNode head) {
        ListNode dummy = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = dummy;
            dummy = head;
            head = next;
        }

        return dummy;
    }
}