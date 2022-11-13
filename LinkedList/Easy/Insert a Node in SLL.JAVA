class Solution
{
    //Function to insert a node at the beginning of the linked list.
    Node insertAtBeginning(Node head, int x)
    {
        Node temp = new Node(x);
        
        if(head!=null)
            temp.next=head;
        
        return temp;
    }
    
    //Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x)
    {
       
        Node temp = new Node(x);
        
        if(head==null)
            return temp;
            
        Node curr = head;
        
        while(curr.next!=null){
            curr=curr.next;
        }
            
        curr.next = temp;
        
        return head;
    }
}
