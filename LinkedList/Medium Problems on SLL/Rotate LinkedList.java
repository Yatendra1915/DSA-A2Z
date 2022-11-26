class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head==null)
            return null;
        
        int len = findLen(head);
        
        k=k%len;
        
        if(k==0)
            return head;
        
        ListNode fast = head;
        
        while(k>0){
            fast=fast.next;
            k--;
        }
        
        ListNode slow = head;
        
        while(fast!=null && fast.next!=null){
            
            slow = slow.next;
            fast = fast.next;
        }
        
        ListNode newHead = slow.next;
        
        slow.next=null;
        fast.next=head;
        
        return newHead;
    }
    
    public int findLen(ListNode head){
        
        int length=0;
        
        while(head!=null){
            length++;
            head=head.next;
        }
        
        return length;
    }
}
