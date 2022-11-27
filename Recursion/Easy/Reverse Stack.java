class Solution
{ 
    static void reverse(Stack<Integer> s)
    {
        // add your code here
        
        if(s.isEmpty())
            return;
            
        int top = s.pop();
        
        reverse(s);
        
        popItems(s,top);
    }
    
    static void popItems(Stack<Integer> s,int top){
        
        if(s.isEmpty()){
            s.push(top);
            return;
        }
            
        
        int temp = s.pop();
        
        popItems(s,top);
        
        s.push(temp);
        
    }
}
