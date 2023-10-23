class Solution {
    public Node copyRandomList(Node head) {
        Node iter = head;
        Node front = head;
        
        // Step 1:
        // Make a copy of each nodes and link them together in between the LL.
        while(iter != null) {
            front = iter.next;
            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = front;
            iter = front;
        }
        
        // Step 2:
        // Assign the random pointers for the copy nodes.
        iter = head;
        while(iter != null) {
            if(iter.random != null) {
                iter.next.random = iter.random.next;
            }
            
            iter = iter.next.next;
        }
        
        // Step 3:
        // Restore the original LL and extract the copy list.
        iter = head;
        Node pseudoHead = new Node(0);
        Node copy = pseudoHead;
        
        while(iter != null) {
            front = iter.next.next;
            
            // extract the copy
            copy.next = iter.next;
            copy = copy.next;
            
            // restore the original list
            iter.next = front;
            
            iter = front;
        }
        
        return pseudoHead.next;
    }
}