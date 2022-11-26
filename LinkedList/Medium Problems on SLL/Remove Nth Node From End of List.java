class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head.next==null)
            return null;
        int count = 1;
        
        ListNode curr = head;
        
        while(curr!=null && count!=n+1){
            count++;
            curr= curr.next;
        }
        
        if(curr==null)
            return head.next;
        
        ListNode nthNode = head;
        
        while(curr!=null && curr.next!=null){
            
            nthNode=nthNode.next;
            curr = curr.next;
        }
        
        
        if(nthNode.next!=null)
            nthNode.next=nthNode.next.next;
        
        return head;
    }
}
