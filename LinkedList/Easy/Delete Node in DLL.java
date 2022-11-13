class Solution{
    
    Node deleteNode(Node head,int x){
		
        // 1 based indexing
		if(x==1){
		    
		    head.next.prev = null;
		    
		    return head.next;
		    
		}
		Node curr = head;
		
		while(curr!=null && x!=1){
		    
		    curr=curr.next;
		    x--;
		}
		
		
		
		curr.prev.next = curr.next;
		
		if(curr.next!=null)
		    curr.next.prev = curr.prev;
		
		return head;
    }
}
