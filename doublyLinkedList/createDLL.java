public class Solution {
    public static Node constructDLL(int []arr) {
        Node head = new Node(arr[0]);
        Node curr = head;

        for(int i=1; i<arr.length; i++) {
            Node temp = new Node(arr[i]);
            head.next = temp;
            temp.prev = head;
            head = head.next;
        }

        return curr;
    }
}