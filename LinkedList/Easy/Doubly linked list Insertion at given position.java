class GfG
{
    
     void addNode(Node head_ref, int pos, int data){
		
		  Node curr = head_ref;
		
       // 0 based indexing
		  while(curr!=null && pos!=0){
		    pos--;
		    curr=curr.next;
		  }
		
		Node temp = new Node(data);
		
		if(curr.next!=null)
		    temp.next = curr.next;
		    
		curr.next = temp;
		
		if(temp.next!=null)
		    temp.next.prev=temp;
		    
		temp.prev=curr;
		
		
	}
}
