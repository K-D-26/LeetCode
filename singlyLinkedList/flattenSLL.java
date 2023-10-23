class GfG {
    Node flatten(Node root) {
	    if(root == null || root.next == null) return root;
	        
	    // recur for the list on the right
	    root.next = flatten(root.next);
	    
	    // now, merge 
	    root = mergeTwoLists(root, root.next);
	    
	    return root;
    }
    
    Node mergeTwoLists(Node a, Node b) {
        Node temp = new Node(0);
        Node res = temp;
        
        while(a != null && b != null) {
            if(a.data < b.data) {
                temp.bottom = a;
                a = a.bottom;
            }
            else {
                temp.bottom = b;
                b = b.bottom;
            }
            temp = temp.bottom;
        }
        
        if(a == null) temp.bottom = b;
        else temp.bottom = a;
        
        return res.bottom;
    }
}