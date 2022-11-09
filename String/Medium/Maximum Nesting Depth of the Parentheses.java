class Solution {
    public int maxDepth(String s) {
        
        Stack<Character> st = new Stack<>();
        
        int maxDepth = 0;
        for(char ch : s.toCharArray()){
            
            if(ch=='(' || ch==')'){
                
                
                if(!st.isEmpty() && st.peek()=='(' && ch==')'){
                    st.pop();
                }
                else{
                    st.push(ch);
                }
                
                maxDepth = Math.max(maxDepth,st.size());
            }
            
        }
        
        return maxDepth;
    }
}
