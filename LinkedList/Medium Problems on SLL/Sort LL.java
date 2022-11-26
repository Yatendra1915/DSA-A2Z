class Solution {
    public ListNode sortList(ListNode head) {
        
        if(head==null || head.next==null)
            return head;
        
        ListNode mid = middle(head);
        ListNode left= sortList(head);
        ListNode right=sortList(mid);
        
        return mergeList(left,right);
    }
    
    public ListNode mergeList(ListNode left,ListNode right){
        
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        
        while(left!=null && right!=null){
            
            if(left.val<right.val){
                
                dummy.next = new ListNode(left.val);
                left=left.next;
            }
            else{
                dummy.next = new ListNode(right.val);
                right=right.next;
            }
            
            dummy = dummy.next;
        }
        
        if(left!=null) dummy.next = left;
        
        if(right!=null) dummy.next= right;
        
        return head.next;
        
    }
    
    public ListNode middle(ListNode node){
        ListNode curr = node;
        ListNode fast = node;
        while(fast.next!=null && fast.next.next!=null){
            curr=curr.next;
            fast=fast.next.next;
        }

        ListNode mid = curr.next;
        curr.next=null;
        
        return mid;
    }
}
