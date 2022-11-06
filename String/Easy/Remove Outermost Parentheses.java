class Solution {
    public String removeOuterParentheses(String s) {
        
        /*
          Approach 
          start adding brackets one by one in stack
            if stack is empty then store its index
            if st.peek == ( and curr bracket is ) then pop
            
            the skip the elements whose index was stored and start appending the rest of element in result from string s
            then return the result
        */
        Stack<Character> st = new Stack<>();
        
        char[] ch = s.toCharArray();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<ch.length;i++){
            
            if(st.isEmpty()){
                
                st.push(ch[i]);
                q.add(i);
                
            }
            else if(st.peek()=='(' && ch[i] == ')'){
                
                st.pop();
                
                if(st.size()==0) q.add(i);
            }
            else{
                st.push(ch[i]);
            }
            
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<ch.length;i++){
            
            if(q.peek()==i){
                q.poll();
            }
            else{
                sb.append(ch[i]);
            }
            
        }
        
        return sb.toString();
    }
}
