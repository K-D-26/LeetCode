public class Solution {
    public static Node sortList(Node head) {
        Node zh = new Node();       // zero head
        Node zt = zh;               // zero tail

        Node oh = new Node();       // one head
        Node ot = oh;               // one head

        Node th = new Node();       // two head
        Node tt = th;               // two head

        while(head != null) {
            if(head.data == 0) {
                zt.next = head;
                zt = zt.next;
            }
            else if(head.data == 1) {
                ot.next = head;
                ot = ot.next;
            }
            else if(head.data == 2) {
                tt.next = head;
                tt = tt.next;
            }
            head = head.next;
        }

        zt.next = oh.next;
        ot.next = th.next;
        tt.next = null;
        
        return zh.next;
    }
}