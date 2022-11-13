public static Node reverseDLL(Node  head)
{
    //Your code here
    
    Node curr = head;
    
    Node prev = null;
    
    while(curr!=null){
        
        Node next = curr.next;
        
        curr.prev = curr.next;
        curr.next=prev;
        
        prev = curr;
        curr = next;
        
    }
    
    return prev;
}
