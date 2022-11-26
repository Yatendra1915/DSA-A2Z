class Solution {
    public ListNode oddEvenList(ListNode head) {
        
        ListNode odd = new ListNode(-1);
        ListNode even= new ListNode(-1);
        
        ListNode oddHead = odd;
        ListNode evenHead = even;
        
        boolean iseven = false;
        while(head!=null){
            
            if(iseven){
                
                even.next = head;
                even = even.next;
                
                iseven=false;
            }
            else{
                
                odd.next=head;
                odd = odd.next;
                
                iseven=true;
            }
            
            head = head.next;
            
        }
        
        odd.next = evenHead.next;
        even.next= null;
        
        return oddHead.next;
    }
}
