class Solution {
    public boolean isPalindrome(ListNode head) {
        
        ListNode mid = findMiddle(head);
        
        // we are giving mid.next as curr to handel case of even length linkedlist;
        ListNode reverseHead = reverse(mid.next,null);
        
        while(reverseHead!=null){
            
            if(head.val!=reverseHead.val)
                return false;
            head=head.next;
            reverseHead=reverseHead.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode curr,ListNode prev){
        
        while(curr!=null){
            
            ListNode next = curr.next;
            
            curr.next=prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    // little change in finding middle
    private ListNode findMiddle(ListNode head){
        
        ListNode slow  = head;
        ListNode fast  = head;
        
        while(fast.next!=null && fast.next.next!=null){
            
            slow = slow.next;
            fast=fast.next.next;
        }
        
        return slow;
    }
}
