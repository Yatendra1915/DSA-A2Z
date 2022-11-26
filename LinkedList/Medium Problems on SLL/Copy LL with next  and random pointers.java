class Solution {
    public Node copyRandomList(Node head) {
        
        Node curr = head;
        if(curr==null)
            return null;
      
        
        while(curr!=null){
            
            Node temp = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next=temp;
            
            curr=temp;
        }
        curr=head;
        
        
        while(curr!=null){
            
            curr.next.random = (curr.random!=null)?curr.random.next:null;
            
            curr=curr.next.next;
        }
        
    
        
        Node copy = head.next;
        curr=copy;
        Node org =head;
        
        while(copy!=null && org!=null){
            org.next=(org.next!=null)?org.next.next:null;
            copy.next=(copy.next!=null)?copy.next.next:null;
            
            org=org.next;
            copy=copy.next;
            
        }
            
        return curr;
    }
}
