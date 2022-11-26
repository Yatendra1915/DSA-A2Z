class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        
        int carry = 0;
        
        while(l1!=null && l2!=null){
            
            int sum = carry + l1.val+l2.val;
            
            int num = sum%10;
            
            dummy.next = new ListNode(num);
            
            carry = sum/10;
            
            l1=l1.next;
            l2=l2.next;
            dummy = dummy.next;
        }
        
        while(l1!=null){
            
            int sum = carry + l1.val;
            
            int num = sum%10;
            
            dummy.next = new ListNode(num);
            
            carry = sum/10;
            dummy = dummy.next;
            l1=l1.next;
        }
        
        while(l2!=null){
            
            int sum = carry + l2.val;
            
            int num = sum%10;
            
            dummy.next = new ListNode(num);
            
            carry = sum/10;
            l2=l2.next;
            dummy = dummy.next;
        }
        
        while(carry!=0){
            
            dummy.next = new ListNode(carry%10);
            carry=carry/10;
            dummy = dummy.next;            
        }
        
        return head.next;
    }
}
