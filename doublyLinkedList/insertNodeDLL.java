public class Solution {
    public static Node insertAtTail(Node list, int K) {
        Node node = new Node(K);
        
        if(list == null) return node;

        Node head = list;
        while(list.next != null) {
            list = list.next;
        }

        list.next = node;
        node.prev = list;
        return head;
    }
}