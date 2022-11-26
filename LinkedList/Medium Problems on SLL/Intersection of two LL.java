public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int lenA = findLength(headA);
        int lenB = findLength(headB);
        
        
        if(lenA>lenB){
            
            int diff = lenA-lenB;
            
            while(diff-->0){
                
                headA=headA.next;
            }
            
            return findIntersection(headA,headB);
        }
        
        else{
            
            int diff = lenB-lenA;
            
            while(diff-->0){
                
                headB=headB.next;
            }
            
            return findIntersection(headA,headB);
        }
        
        
    }
    
    private ListNode findIntersection(ListNode headA,ListNode headB){
        
        while(headA!=null && headB!=null){
            
            if(headA==headB){
                return headA;
            }
            headA=headA.next;
            headB=headB.next;
        }
        
        return null;
    }
    
    private int findLength(ListNode head){
        
        int count = 0;
        
        while(head!=null){
            count++;
            head = head.next;
        }
        
        return count;
    }
}
