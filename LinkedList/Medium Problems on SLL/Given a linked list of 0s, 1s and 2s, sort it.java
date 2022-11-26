class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // add your code here
        
        Node zero = new Node(-1);
        Node zeroHead = zero;
        
        Node one = new Node(-1);
        Node oneHead = one;
        
        Node two = new Node(-1);
        Node twoHead = two;
        
        while(head!=null){
            
            if(head.data==0){
                zero.next = new Node(0);
                zero= zero.next;
            }
            else if(head.data==1){
                one.next = new Node(1);
                one = one.next;
            }
            else{
                two.next=new Node(2);
                two = two.next;
            }
            
            head = head.next;
        }
        
        zero.next = (oneHead.next!=null)?oneHead.next:twoHead.next;
        // if above cond is not satisfied then one.next = null so this statement will not have any revelance beacuse null->twohead.next;
        one.next = twoHead.next;
      
        // make it null to avoid and errors
        two.next=null;
        
        return zeroHead.next;
    }
}
